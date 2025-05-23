package com.gepardec;

import org.junit.jupiter.api.Test;
import org.openrewrite.java.Java17Parser;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;

import static org.openrewrite.java.Assertions.java;

public class RenameDoSomethingOfTypeTest implements RewriteTest {

    @Override
    public void defaults(RecipeSpec spec) {
        spec
//                .recipe(new RenameDoSomethingOfType())
                .parser(Java17Parser.builder()
                        .dependsOn("""
                                package com.gepardec;
                                public class Type {
                                    public void doSomething() {}
                                    public void doAnything() {}
                                    public void doNothing() {}
                                }
                                """,
                                """
                                package com.gepardec;
                                public class OtherType {
                                    public void doSomething() {}
                                    public void doAnything() {}
                                    public void doNothing() {}
                                }
                                """));
    }

    @Test
    public void givenDoSomethingCall_whenOfType_thenReplaceWithDoNothing() {
        rewriteRun(
                java("""
                        package com.gepardec;
                        
                        public class Test {
                            public void test() {
                                Type instance = new Type();
                                instance.doSomething();
                            }
                        }
                        """, """
                        package com.gepardec;
                        
                        public class Test {
                            public void test() {
                                Type instance = new Type();
                                instance.doNothing();
                            }
                        }
                        """
                )
        );
    }

    @Test
    public void givenAnotherCall_whenOfType_thenDontReplace() {
        rewriteRun(
                java("""
                        package com.gepardec;
                        
                        public class Test {
                            public void test() {
                                Type instance = new Type();
                                instance.doAnything();
                            }
                        }
                        """
                )
        );
    }

    @Test
    public void givenDoSomethingCall_whenNotOfType_thenDontReplace() {
        rewriteRun(
                java("""
                        package com.gepardec;
                        
                        public class Test {
                            public void test() {
                                OtherType instance = new OtherType();
                                instance.doSomething();
                            }
                        }
                        """
                )
        );
    }
}
