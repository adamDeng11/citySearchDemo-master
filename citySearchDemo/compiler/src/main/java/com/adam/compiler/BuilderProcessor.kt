package com.adam.compiler

import com.adam.annotations.Builder
import com.adam.annotations.Optional
import com.adam.annotations.Required
import com.bennyhuo.aptutils.AptContext
import com.bennyhuo.aptutils.logger.Logger
import sun.awt.AppContext
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

/**
 * Created by adamDeng on 2019/10/24
 * Copyright © 2019年 . All rights reserved.
 */
class BuilderProcessor:AbstractProcessor(){

    private val supportedAnnotations= setOf(Builder::class.java,Required::class.java,Optional::class.java)

    override fun getSupportedSourceVersion()=SourceVersion.RELEASE_7

    override fun getSupportedAnnotationTypes()=supportedAnnotations.mapTo(HashSet<String>(),Class<*>::getCanonicalName)

    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
        AptContext.init(processingEnv)
    }

    override fun process(annotations: MutableSet<out TypeElement>?, env: RoundEnvironment?): Boolean {
        env?.getElementsAnnotatedWith(Builder::class.java)?.forEach {
            Logger.warn(it,it.simpleName.toString())
        }
        return true
    }
}
