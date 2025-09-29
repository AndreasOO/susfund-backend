package org.andjos.susfund.statemachine.util;

import org.andjos.susfund.entity.caseentity.CaseEntity;
import org.andjos.susfund.entity.supporttype.SupportTypeNode;
import org.andjos.susfund.statemachine.StateMachine;
import org.andjos.susfund.statemachine.state.DecisionRoundState;
import org.andjos.susfund.statemachine.transition.Transition;
import org.andjos.susfund.statemachine.trigger.Trigger;

import java.util.HashMap;
import java.util.Map;

public class SupportTypeUtil {

    public StateMachine getCaseStateMachine(CaseEntity caseEntity) {
        Map<DecisionRoundState, Map<Trigger, Transition>> stateMap = getStateMapForSupportType( caseEntity.getSupportTypeNode());
        return createStateMachine(caseEntity, stateMap);
    }

    protected Map<DecisionRoundState, Map<Trigger, Transition>> getStateMapForSupportType(SupportTypeNode supportTypeNode) {

        Map<Trigger, Transition> transitions = new HashMap<>();
        //TODO add transition objects to triggers


        Map<DecisionRoundState, Map<Trigger, Transition>> stateMap = new HashMap<>();
        //TODO add transitions to statemap

    return null;
    }

    protected StateMachine createStateMachine(CaseEntity caseEntity, Map<DecisionRoundState, Map<Trigger, Transition>> stateMap) {
return null;
    }
}
