/*
 * Configurate
 * Copyright (C) zml and Configurate contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.spongepowered.configurate.serialize;

import static java.util.Objects.requireNonNull;

import com.google.common.reflect.TypeToken;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.configurate.objectmapping.ObjectMappingException;
import org.spongepowered.configurate.util.CheckedConsumer;

import java.lang.reflect.Array;
import java.util.function.Predicate;

/**
 * A serializer for array classes. Primitive arrays need special handling
 * because they don't have autoboxing like single primitives do.
 *
 * @param <T> array type
 */
abstract class ArraySerializer<T> extends AbstractListChildSerializer<T> {

    @Override
    TypeToken<?> getElementType(final TypeToken<?> containerType) {
        return requireNonNull(containerType.getComponentType(), "Must be array type");
    }

    static class Objects extends ArraySerializer<Object[]> {

        public static Predicate<TypeToken<Object[]>> predicate() {
            return token -> {
                final @Nullable TypeToken<?> componentType = token.getComponentType();
                return componentType != null && !componentType.isPrimitive();
            };
        }

        @Override
        Object[] createNew(final int length, final TypeToken<?> elementType) {
            return (Object[]) Array.newInstance(elementType.getRawType(), length);
        }

        @Override
        void forEachElement(final Object[] collection, final CheckedConsumer<Object, ObjectMappingException> action) throws ObjectMappingException {
            for (Object o : collection) {
                action.accept(o);
            }
        }

        @Override
        void deserializeSingle(final int index, final Object[] collection, final @Nullable Object deserialized) {
            collection[index] = deserialized;
        }

    }

    static class Booleans extends ArraySerializer<boolean[]> {

        static final TypeToken<boolean[]> TYPE = TypeToken.of(boolean[].class);

        @Override
        boolean[] createNew(final int length, final TypeToken<?> elementType) {
            return new boolean[length];
        }

        @Override
        void forEachElement(final boolean[] collection, final CheckedConsumer<Object, ObjectMappingException> action) throws ObjectMappingException {
            for (boolean b : collection) {
                action.accept(b);
            }
        }

        @Override
        void deserializeSingle(final int index, final boolean[] collection, final @Nullable Object deserialized) throws ObjectMappingException {
            collection[index] = deserialized == null ? false : Scalars.BOOLEAN.deserialize(deserialized);
        }

    }

    static class Bytes extends ArraySerializer<byte[]> {

        static final TypeToken<byte[]> TYPE = TypeToken.of(byte[].class);

        @Override
        byte[] createNew(final int length, final TypeToken<?> elementType) {
            return new byte[length];
        }

        @Override
        void forEachElement(final byte[] collection, final CheckedConsumer<Object, ObjectMappingException> action) throws ObjectMappingException {
            for (byte b : collection) {
                action.accept(b);
            }
        }

        @Override
        void deserializeSingle(final int index, final byte[] collection, final @Nullable Object deserialized) throws ObjectMappingException {
            collection[index] = deserialized == null ? 0 : Scalars.INTEGER.deserialize(deserialized).byteValue();
        }

    }

    static class Chars extends ArraySerializer<char[]> {

        static final TypeToken<char[]> TYPE = TypeToken.of(char[].class);

        @Override
        char[] createNew(final int length, final TypeToken<?> elementType) {
            return new char[length];
        }

        @Override
        void forEachElement(final char[] collection, final CheckedConsumer<Object, ObjectMappingException> action) throws ObjectMappingException {
            for (char b : collection) {
                action.accept(b);
            }
        }

        @Override
        void deserializeSingle(final int index, final char[] collection, final @Nullable Object deserialized) throws ObjectMappingException {
            collection[index] = deserialized == null ? 0 : Scalars.CHAR.deserialize(deserialized);
        }

    }

    static class Shorts extends ArraySerializer<short[]> {

        static final TypeToken<short[]> TYPE = TypeToken.of(short[].class);

        @Override
        short[] createNew(final int length, final TypeToken<?> elementType) {
            return new short[length];
        }

        @Override
        void forEachElement(final short[] collection, final CheckedConsumer<Object, ObjectMappingException> action) throws ObjectMappingException {
            for (short b : collection) {
                action.accept(b);
            }
        }

        @Override
        void deserializeSingle(final int index, final short[] collection, final @Nullable Object deserialized) throws ObjectMappingException {
            collection[index] = deserialized == null ? 0 : Scalars.INTEGER.deserialize(deserialized).shortValue();
        }

    }

    static class Ints extends ArraySerializer<int[]> {

        static final TypeToken<int[]> TYPE = TypeToken.of(int[].class);

        @Override
        int[] createNew(final int length, final TypeToken<?> elementType) {
            return new int[length];
        }

        @Override
        void forEachElement(final int[] collection, final CheckedConsumer<Object, ObjectMappingException> action) throws ObjectMappingException {
            for (int b : collection) {
                action.accept(b);
            }
        }

        @Override
        void deserializeSingle(final int index, final int[] collection, final @Nullable Object deserialized) throws ObjectMappingException {
            collection[index] = deserialized == null ? 0 : Scalars.INTEGER.deserialize(deserialized);
        }

    }

    static class Longs extends ArraySerializer<long[]> {

        static final TypeToken<long[]> TYPE = TypeToken.of(long[].class);

        @Override
        long[] createNew(final int length, final TypeToken<?> elementType) {
            return new long[length];
        }

        @Override
        void forEachElement(final long[] collection, final CheckedConsumer<Object, ObjectMappingException> action) throws ObjectMappingException {
            for (long b : collection) {
                action.accept(b);
            }
        }

        @Override
        void deserializeSingle(final int index, final long[] collection, final @Nullable Object deserialized) throws ObjectMappingException {
            collection[index] = deserialized == null ? 0 : Scalars.LONG.deserialize(deserialized);
        }

    }

    static class Floats extends ArraySerializer<float[]> {

        static final TypeToken<float[]> TYPE = TypeToken.of(float[].class);

        @Override
        float[] createNew(final int length, final TypeToken<?> elementType) {
            return new float[length];
        }

        @Override
        void forEachElement(final float[] collection, final CheckedConsumer<Object, ObjectMappingException> action) throws ObjectMappingException {
            for (float b : collection) {
                action.accept(b);
            }
        }

        @Override
        void deserializeSingle(final int index, final float[] collection, final @Nullable Object deserialized) throws ObjectMappingException {
            collection[index] = deserialized == null ? 0 : Scalars.FLOAT.deserialize(deserialized);
        }

    }

    static class Doubles extends ArraySerializer<double[]> {

        static final TypeToken<double[]> TYPE = TypeToken.of(double[].class);

        @Override
        double[] createNew(final int length, final TypeToken<?> elementType) {
            return new double[length];
        }

        @Override
        void forEachElement(final double[] collection, final CheckedConsumer<Object, ObjectMappingException> action) throws ObjectMappingException {
            for (double b : collection) {
                action.accept(b);
            }
        }

        @Override
        void deserializeSingle(final int index, final double[] collection, final @Nullable Object deserialized) throws ObjectMappingException {
            collection[index] = deserialized == null ? 0 : Scalars.DOUBLE.deserialize(deserialized);
        }

    }

}
