package xyz.bumbing.extension;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import xyz.bumbing.annotation.SlowTest;

import java.lang.reflect.Method;

public class FindSlowTestExtension2 implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private long  THRESHOLD;

    public FindSlowTestExtension2(long THRESHOLD){
        this.THRESHOLD=THRESHOLD;
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {

        Method requiredTestMethod = extensionContext.getRequiredTestMethod();
        SlowTest annotation = requiredTestMethod.getAnnotation(SlowTest.class);

        ExtensionContext.Store store =getStore(extensionContext);
        Long start_time = store.remove("START_TIME2", long.class);
        long duration = System.currentTimeMillis()-start_time;
        if(duration>THRESHOLD && annotation==null){
            System.out.printf("ex2, Please consider mark method [%s] with @SlowTest.\n",extensionContext.getRequiredTestMethod().getName());
        }
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        ExtensionContext.Store store = getStore(extensionContext);
        store.put("START_TIME2",System.currentTimeMillis());
    }

    private ExtensionContext.Store getStore(ExtensionContext extensionContext) {
        String testClassName = extensionContext.getRequiredTestClass().getName();
        String testMethodName = extensionContext.getRequiredTestMethod().getName();
        return extensionContext.getStore(ExtensionContext.Namespace.create(testClassName, testMethodName));
    }
}
