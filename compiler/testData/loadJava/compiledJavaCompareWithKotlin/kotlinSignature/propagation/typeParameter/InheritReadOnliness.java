package test;

import org.jetbrains.annotations.NotNull;
import jet.runtime.typeinfo.KotlinSignature;
import org.jetbrains.jet.jvm.compiler.annotation.ExpectLoadError;
import java.util.*;

public interface InheritReadOnliness {

    public interface Super {
        @KotlinSignature("fun <A: List<String>> foo(a: A)")
        <A extends List<String>> void foo(A a);
    }

    public interface Sub extends Super {
        <B extends List<String>> void foo(B b);
    }
}
