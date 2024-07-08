package com.test.springboot001.anno;

import com.test.springboot001.mdoel.Apple;
import com.test.springboot001.mdoel.Banana;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class FruitImportDefintionRegistar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        registry.registerBeanDefinition("apple",new RootBeanDefinition(Apple.class));
        registry.registerBeanDefinition("banabna",new RootBeanDefinition(Banana.class));
    }
}
