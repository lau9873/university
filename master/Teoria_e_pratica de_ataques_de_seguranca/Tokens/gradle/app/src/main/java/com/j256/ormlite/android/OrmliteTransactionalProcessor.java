package com.j256.ormlite.android;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Completion;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

/* loaded from: classes.dex */
public class OrmliteTransactionalProcessor implements Processor {
    public static final Set<Class<? extends Annotation>> annotationSet = new HashSet();
    public ProcessingEnvironment processingEnv;

    static {
        annotationSet.add(DatabaseTable.class);
        annotationSet.add(DatabaseField.class);
    }

    public Iterable<? extends Completion> getCompletions(Element element, AnnotationMirror annotationMirror, ExecutableElement executableElement, String str) {
        return Collections.emptyList();
    }

    public Set<String> getSupportedAnnotationTypes() {
        HashSet hashSet = new HashSet();
        for (Class<? extends Annotation> cls : annotationSet) {
            hashSet.add(cls.getName());
        }
        return hashSet;
    }

    public Set<String> getSupportedOptions() {
        return Collections.emptySet();
    }

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_6;
    }

    public void init(ProcessingEnvironment processingEnvironment) {
        this.processingEnv = processingEnvironment;
    }

    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        for (Class<? extends Annotation> cls : annotationSet) {
            for (Element element : roundEnvironment.getElementsAnnotatedWith(cls)) {
                PrintStream printStream = System.out;
                printStream.println("-- Element " + element + " has annotation " + cls);
                Messager messager = this.processingEnv.getMessager();
                Diagnostic.Kind kind = Diagnostic.Kind.ERROR;
                messager.printMessage(kind, element + " error");
            }
        }
        return true;
    }
}
