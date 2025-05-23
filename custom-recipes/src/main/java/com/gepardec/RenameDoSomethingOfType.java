package com.gepardec;

import org.openrewrite.ExecutionContext;
import org.openrewrite.NlsRewrite;
import org.openrewrite.Recipe;
import org.openrewrite.TreeVisitor;
import org.openrewrite.java.JavaIsoVisitor;
import org.openrewrite.java.JavaParser;
import org.openrewrite.java.JavaTemplate;
import org.openrewrite.java.tree.J;

public class RenameDoSomethingOfType extends Recipe {
    @Override
    public @NlsRewrite.DisplayName String getDisplayName() {
        return "Rename doSomething() of Type";
    }

    @Override
    public @NlsRewrite.Description String getDescription() {
        return "Renames only doSomething() of Type to doNothing().";
    }

    @Override
    public TreeVisitor<?, ExecutionContext> getVisitor() {
        return new JavaIsoVisitor<>() {
            @Override
            public J.MethodInvocation visitMethodInvocation(J.MethodInvocation method, ExecutionContext executionContext) {
                method = super.visitMethodInvocation(method, executionContext);

                if (!method.getSimpleName().equals("doSomething")) {
                    return method;
                }

                if (!method.getSelect().getType().toString().equals("com.gepardec.Type")) {
                    return method;
                }

                return JavaTemplate.builder("#{any(com.gepardec.Type)}.doNothing()")
                        .contextSensitive()
                        .javaParser(JavaParser.fromJavaVersion().dependsOn("" +
                                """
                                package com.gepardec;
                                public class Type {
                                    public void doSomething() {}
                                    public void doAnything() {}
                                    public void doNothing() {}
                                }
                                """))
                        .build()
                        .apply(this.getCursor(),
                                method.getCoordinates().replace(),
                                method.getSelect());
            }
        };
    }
}
