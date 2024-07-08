package com.test.springboot001.anno;

import com.test.springboot001.mdoel.Apple;
import com.test.springboot001.mdoel.Banana;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class FruitImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Apple.class.getName(), Banana.class.getName()};
    }
}

