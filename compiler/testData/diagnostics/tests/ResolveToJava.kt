// FILE: f.kt

import java.*
import java.util.*
import <!UNRESOLVED_REFERENCE!>utils<!>.*

import java.io.PrintStream
import <!PLATFORM_CLASS_MAPPED_TO_KOTLIN!>java.lang.Comparable<!> as Com

val l : MutableList<in Int> = ArrayList<Int>()

fun test(<!UNUSED_PARAMETER!>l<!> : <!PLATFORM_CLASS_MAPPED_TO_KOTLIN!>java.util.List<Int><!>) {
  val <!UNUSED_VARIABLE!>x<!> : java.<!UNRESOLVED_REFERENCE!>List<!>
  val <!UNUSED_VARIABLE!>y<!> : <!PLATFORM_CLASS_MAPPED_TO_KOTLIN!>java.util.List<Int><!>
  val <!UNUSED_VARIABLE!>b<!> : <!PLATFORM_CLASS_MAPPED_TO_KOTLIN!>java.lang.Object<!>
  val <!UNUSED_VARIABLE!>a<!> : <!PLATFORM_CLASS_MAPPED_TO_KOTLIN!>util.List<Int><!>
  val <!UNUSED_VARIABLE!>z<!> : java.<!UNRESOLVED_REFERENCE!>utils<!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>List<!><Int>

  val <!UNUSED_VARIABLE!>f<!> : java.io.File? = null

  Collections.<!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER, FUNCTION_CALL_EXPECTED!>emptyList<!>
  Collections.<!FUNCTION_CALL_EXPECTED!>emptyList<Int><!>
  Collections.emptyList<Int>()
  Collections.<!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>emptyList<!>()

  Collections.singleton<Int>(1) : Set<Int>?
  Collections.singleton<Int>(<!CONSTANT_EXPECTED_TYPE_MISMATCH!>1.0<!>)

  <!UNRESOLVED_REFERENCE!>List<!><Int>


  val <!UNUSED_VARIABLE!>o<!> = "sdf" as <!PLATFORM_CLASS_MAPPED_TO_KOTLIN!>Object<!>

  try {
    // ...
  }
  catch(e: Exception) {
    System.out.println(e.getMessage())
  }

  PrintStream("sdf")

  val c : <!PLATFORM_CLASS_MAPPED_TO_KOTLIN!>Com<Int><!>? = null

  c : <!PLATFORM_CLASS_MAPPED_TO_KOTLIN!>java.lang.Comparable<Int><!>?

//  Collections.sort<Integer>(ArrayList<Integer>())
  xxx.<!UNRESOLVED_REFERENCE!>Class<!>()
}


// FILE: f.kt
package xxx
  import java.lang.Class;