/*
 * Copyright 2010-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.lang.resolve.java.kt;

import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jet.lang.resolve.java.JvmStdlibNames;

/**
 * @author Stepan Koltsov
 */
public class JetClassAnnotation extends PsiAnnotationWrapper {

    public JetClassAnnotation(@Nullable PsiAnnotation psiAnnotation) {
        super(psiAnnotation);
    }
    
    private String signature;
    public String signature() {
        if (signature == null) {
            signature = getStringAttribute(JvmStdlibNames.JET_CLASS_SIGNATURE, "");
        }
        return signature;
    }
    
    @NotNull
    public static JetClassAnnotation get(PsiClass psiClass) {
        return new JetClassAnnotation(psiClass.getModifierList().findAnnotation(JvmStdlibNames.JET_CLASS.getFqName().getFqName()));
    }
}
