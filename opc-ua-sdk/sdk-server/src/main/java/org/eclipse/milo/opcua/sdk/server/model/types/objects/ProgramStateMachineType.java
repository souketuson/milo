/*
 * Copyright (c) 2019 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.sdk.server.model.types.objects;

import org.eclipse.milo.opcua.sdk.core.QualifiedProperty;
import org.eclipse.milo.opcua.sdk.core.ValueRanks;
import org.eclipse.milo.opcua.sdk.server.model.types.variables.FiniteStateVariableType;
import org.eclipse.milo.opcua.sdk.server.model.types.variables.FiniteTransitionVariableType;
import org.eclipse.milo.opcua.sdk.server.model.types.variables.ProgramDiagnosticType;
import org.eclipse.milo.opcua.sdk.server.model.types.variables.PropertyType;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.structured.ProgramDiagnosticDataType;

public interface ProgramStateMachineType extends FiniteStateMachineType {
    QualifiedProperty<Boolean> CREATABLE = new QualifiedProperty<>(
        "http://opcfoundation.org/UA/",
        "Creatable",
        NodeId.parse("ns=0;i=1"),
        ValueRanks.Scalar,
        Boolean.class
    );

    QualifiedProperty<Boolean> DELETABLE = new QualifiedProperty<>(
        "http://opcfoundation.org/UA/",
        "Deletable",
        NodeId.parse("ns=0;i=1"),
        ValueRanks.Scalar,
        Boolean.class
    );

    QualifiedProperty<Boolean> AUTO_DELETE = new QualifiedProperty<>(
        "http://opcfoundation.org/UA/",
        "AutoDelete",
        NodeId.parse("ns=0;i=1"),
        ValueRanks.Scalar,
        Boolean.class
    );

    QualifiedProperty<Integer> RECYCLE_COUNT = new QualifiedProperty<>(
        "http://opcfoundation.org/UA/",
        "RecycleCount",
        NodeId.parse("ns=0;i=6"),
        ValueRanks.Scalar,
        Integer.class
    );

    QualifiedProperty<UInteger> INSTANCE_COUNT = new QualifiedProperty<>(
        "http://opcfoundation.org/UA/",
        "InstanceCount",
        NodeId.parse("ns=0;i=7"),
        ValueRanks.Scalar,
        UInteger.class
    );

    QualifiedProperty<UInteger> MAX_INSTANCE_COUNT = new QualifiedProperty<>(
        "http://opcfoundation.org/UA/",
        "MaxInstanceCount",
        NodeId.parse("ns=0;i=7"),
        ValueRanks.Scalar,
        UInteger.class
    );

    QualifiedProperty<UInteger> MAX_RECYCLE_COUNT = new QualifiedProperty<>(
        "http://opcfoundation.org/UA/",
        "MaxRecycleCount",
        NodeId.parse("ns=0;i=7"),
        ValueRanks.Scalar,
        UInteger.class
    );

    PropertyType getCreatableNode();

    Boolean getCreatable();

    void setCreatable(Boolean value);

    PropertyType getDeletableNode();

    Boolean getDeletable();

    void setDeletable(Boolean value);

    PropertyType getAutoDeleteNode();

    Boolean getAutoDelete();

    void setAutoDelete(Boolean value);

    PropertyType getRecycleCountNode();

    Integer getRecycleCount();

    void setRecycleCount(Integer value);

    PropertyType getInstanceCountNode();

    UInteger getInstanceCount();

    void setInstanceCount(UInteger value);

    PropertyType getMaxInstanceCountNode();

    UInteger getMaxInstanceCount();

    void setMaxInstanceCount(UInteger value);

    PropertyType getMaxRecycleCountNode();

    UInteger getMaxRecycleCount();

    void setMaxRecycleCount(UInteger value);

    FiniteStateVariableType getCurrentStateNode();

    LocalizedText getCurrentState();

    void setCurrentState(LocalizedText value);

    FiniteTransitionVariableType getLastTransitionNode();

    LocalizedText getLastTransition();

    void setLastTransition(LocalizedText value);

    ProgramDiagnosticType getProgramDiagnosticsNode();

    ProgramDiagnosticDataType getProgramDiagnostics();

    void setProgramDiagnostics(ProgramDiagnosticDataType value);

    BaseObjectType getFinalResultDataNode();

    StateType getReadyNode();

    StateType getRunningNode();

    StateType getSuspendedNode();

    StateType getHaltedNode();

    TransitionType getHaltedToReadyNode();

    TransitionType getReadyToRunningNode();

    TransitionType getRunningToHaltedNode();

    TransitionType getRunningToReadyNode();

    TransitionType getRunningToSuspendedNode();

    TransitionType getSuspendedToRunningNode();

    TransitionType getSuspendedToHaltedNode();

    TransitionType getSuspendedToReadyNode();

    TransitionType getReadyToHaltedNode();
}
