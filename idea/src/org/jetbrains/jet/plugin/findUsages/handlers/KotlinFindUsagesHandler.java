/*
 * Copyright 2010-2013 JetBrains s.r.o.
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

package org.jetbrains.jet.plugin.findUsages.handlers;

import com.intellij.find.findUsages.FindUsagesHandler;
import com.intellij.find.findUsages.FindUsagesOptions;
import com.intellij.find.findUsages.JavaFindUsagesOptions;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import com.intellij.usageView.UsageInfo;
import com.intellij.util.Processor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jet.plugin.findUsages.FindUsagesPackage;
import org.jetbrains.jet.plugin.findUsages.KotlinFindUsagesHandlerFactory;
import org.jetbrains.jet.plugin.search.usagesSearch.DeclarationUsagesSearchHelper;
import org.jetbrains.jet.plugin.search.usagesSearch.UsagesSearch;
import org.jetbrains.jet.plugin.search.usagesSearch.UsagesSearchTarget;

import java.util.Collection;
import java.util.Collections;

public abstract class KotlinFindUsagesHandler<T extends PsiElement> extends FindUsagesHandler {
    private final KotlinFindUsagesHandlerFactory factory;
    private final Collection<? extends PsiElement> elementsToSearch;

    public KotlinFindUsagesHandler(
            @NotNull T psiElement,
            @NotNull Collection<? extends PsiElement> elementsToSearch,
            @NotNull KotlinFindUsagesHandlerFactory factory
    ) {
        super(psiElement);
        this.factory = factory;
        this.elementsToSearch = elementsToSearch;
    }

    @SuppressWarnings("unchecked")
    @NotNull
    public T getElement() {
        return (T)getPsiElement();
    }

    public KotlinFindUsagesHandler(@NotNull T psiElement, @NotNull KotlinFindUsagesHandlerFactory factory) {
        this(psiElement, Collections.<PsiElement>emptyList(), factory);
    }

    public final KotlinFindUsagesHandlerFactory getFactory() {
        return factory;
    }

    protected static boolean processUsage(Processor<UsageInfo> processor, PsiReference ref) {
        TextRange rangeInElement = ref.getRangeInElement();
        return processor.process(new UsageInfo(ref.getElement(), rangeInElement.getStartOffset(), rangeInElement.getEndOffset(), false));
    }

    protected static boolean processUsage(@NotNull Processor<UsageInfo> processor, @NotNull PsiElement element) {
        return processor.process(new UsageInfo(element));
    }

    @NotNull
    @Override
    public PsiElement[] getPrimaryElements() {
        return elementsToSearch.isEmpty()
               ? new PsiElement[] {getPsiElement()}
               : elementsToSearch.toArray(new PsiElement[elementsToSearch.size()]);
    }

    @Override
    public boolean processElementUsages(
            @NotNull PsiElement element, @NotNull Processor<UsageInfo> processor, @NotNull FindUsagesOptions options
    ) {
        if (options.isUsages) {
            DeclarationUsagesSearchHelper<PsiNamedElement> helper = FindUsagesPackage.toHelper((JavaFindUsagesOptions) options);
            UsagesSearchTarget<PsiNamedElement> target = FindUsagesPackage.toSearchTarget(options, (PsiNamedElement) element, true);

            for (PsiReference ref : UsagesSearch.instance$.search(helper.newRequest(target))) {
                if (!processUsage(processor, ref)) return false;
            }
        }
        return true;
    }
}
