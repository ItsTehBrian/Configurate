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

import com.google.common.reflect.TypeToken;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.configurate.objectmapping.ObjectMappingException;
import org.spongepowered.configurate.util.CheckedConsumer;

import java.lang.reflect.ParameterizedType;
import java.util.LinkedHashSet;
import java.util.Set;

class SetSerializer extends AbstractListChildSerializer<Set<?>> {

    static TypeToken<Set<?>> TYPE = new TypeToken<Set<?>>() {};

    @Override
    TypeToken<?> getElementType(final TypeToken<?> containerType) throws ObjectMappingException {
        if (!(containerType.getType() instanceof ParameterizedType)) {
            throw new ObjectMappingException("Raw types are not supported for collections");
        }
        return containerType.resolveType(Set.class.getTypeParameters()[0]);
    }

    @Override
    Set<?> createNew(final int length, final TypeToken<?> elementType) {
        return new LinkedHashSet<>(length);
    }

    @Override
    void forEachElement(final Set<?> collection, final CheckedConsumer<Object, ObjectMappingException> action) throws ObjectMappingException {
        for (Object el: collection) {
            action.accept(el);
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    void deserializeSingle(final int index, final Set<?> collection, final @Nullable Object deserialized) {
        ((Set) collection).add(deserialized);
    }

}
