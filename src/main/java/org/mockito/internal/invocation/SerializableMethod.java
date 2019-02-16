/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.invocation;

import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.creation.SuspendMethod;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.coveragetracking.*;

public class SerializableMethod implements Serializable, MockitoMethod {

    private static final long serialVersionUID = 6005610965006048445L;

    private final Class<?> declaringClass;
    private final String methodName;
    private final Class<?>[] parameterTypes;
    private final Class<?> returnType;
    private final Class<?>[] exceptionTypes;
    private final boolean isVarArgs;
    private final boolean isAbstract;

    private volatile transient Method method;

    public SerializableMethod(Method method) {
        this.method = method;
        declaringClass = method.getDeclaringClass();
        methodName = method.getName();
        parameterTypes = SuspendMethod.trimSuspendParameterTypes(method.getParameterTypes());
        returnType = method.getReturnType();
        exceptionTypes = method.getExceptionTypes();
        isVarArgs = method.isVarArgs();
        isAbstract = (method.getModifiers() & Modifier.ABSTRACT) != 0;
    }

    public String getName() {
        return methodName;
    }

    public Class<?> getReturnType() {
        return returnType;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public Class<?>[] getExceptionTypes() {
        return exceptionTypes;
    }

    public boolean isVarArgs() {
        return isVarArgs;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public Method getJavaMethod() {
        if (method != null) {
            return method;
        }
        try {
            method = declaringClass.getDeclaredMethod(methodName, parameterTypes);
            return method;
        } catch (SecurityException e) {
            String message = String.format(
                    "The method %1$s.%2$s is probably private or protected and cannot be mocked.\n" +
                            "Please report this as a defect with an example of how to reproduce it.", declaringClass, methodName);
            throw new MockitoException(message, e);
        } catch (NoSuchMethodException e) {
            String message = String.format(
                    "The method %1$s.%2$s does not exists and you should not get to this point.\n" +
                            "Please report this as a defect with an example of how to reproduce it.", declaringClass, methodName);
            throw new MockitoException(message, e);
        }
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            Coverage.SerializableMethodEquals[0] = true;
            return true;
        }
        if (obj == null) {
            Coverage.SerializableMethodEquals[1] = true;
            return false;
        }
        if (getClass() != obj.getClass()) {
            Coverage.SerializableMethodEquals[2] = true;
            return false;
        }
        SerializableMethod other = (SerializableMethod) obj;
        if (declaringClass == null) {
            if (other.declaringClass != null) {
                Coverage.SerializableMethodEquals[3] = true;
                return false;
            }
        } else if (!declaringClass.equals(other.declaringClass)) {
            Coverage.SerializableMethodEquals[4] = true;
            return false;
        }
        if (methodName == null) {
            if (other.methodName != null) {
                Coverage.SerializableMethodEquals[5] = true;
                return false;
            }
        } else if (!methodName.equals(other.methodName)) {
            Coverage.SerializableMethodEquals[6] = true;
            return false;
        }
        if (!Arrays.equals(parameterTypes, other.parameterTypes)) {
            Coverage.SerializableMethodEquals[7] = true;
            return false;
        }
        if (returnType == null) {
            if (other.returnType != null) {
                Coverage.SerializableMethodEquals[8] = true;
                return false;
            }
        } else if (!returnType.equals(other.returnType)) {
            Coverage.SerializableMethodEquals[9] = true;
            return false;
        }
        Coverage.SerializableMethodEquals[10] = true;
        return true;
    }
}
