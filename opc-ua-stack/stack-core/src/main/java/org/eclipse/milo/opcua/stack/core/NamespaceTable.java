/*
 * Copyright (c) 2019 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.stack.core;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Consumer;
import javax.annotation.Nullable;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UShort;

import static org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned.ushort;

public class NamespaceTable {

    public static final String OPC_UA_NAMESPACE = "http://opcfoundation.org/UA/";

    private final BiMap<UShort, String> uriTable = HashBiMap.create();

    public NamespaceTable() {
        uriTable.put(ushort(0), OPC_UA_NAMESPACE);
    }

    public synchronized UShort addUri(String uri) {
        UShort index = ushort(1);
        while (uriTable.containsKey(index)) {
            index = ushort(index.intValue() + 1);
            if (index.intValue() == 65535) {
                throw new UaRuntimeException(StatusCodes.Bad_InternalError, "uri table full");
            }
        }
        uriTable.put(index, uri);

        return index;
    }

    public synchronized void putUri(String uri, UShort index) {
        uriTable.put(index, uri);
    }

    public synchronized String getUri(UShort index) {
        return uriTable.get(index);
    }

    /**
     * @param uri the namespace URI to look up.
     * @return the index of the namespace URI, or {@code null} if it is not present.
     */
    @Nullable
    public synchronized UShort getIndex(String uri) {
        return uriTable.inverse().getOrDefault(uri, null);
    }

    public synchronized void update(Consumer<BiMap<UShort, String>> uriTableConsumer) {
        uriTableConsumer.accept(uriTable);
    }

    public synchronized String[] toArray() {
        return uriTable.entrySet().stream()
            .sorted(Comparator.comparingInt(e -> e.getKey().intValue()))
            .map(Map.Entry::getValue)
            .toArray(String[]::new);
    }

}
