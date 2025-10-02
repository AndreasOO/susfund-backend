package org.andjos.susfund.statemachine.util;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andjos.susfund.entity.caseentity.CaseDecisionType;
import org.andjos.susfund.entity.caseentity.CaseEntity;
import org.andjos.susfund.entity.caseentity.CaseStatus;
import org.andjos.susfund.entity.supporttype.SupportTypeNode;
import org.andjos.susfund.statemachine.DefaultStateMachine;
import org.andjos.susfund.statemachine.StateMachine;
import org.andjos.susfund.statemachine.state.DecisionRoundState;
import org.andjos.susfund.statemachine.transition.DecisionRoundStateTransition;
import org.andjos.susfund.statemachine.transition.SaveFieldsTransition;
import org.andjos.susfund.statemachine.transition.Transition;
import org.andjos.susfund.statemachine.trigger.Trigger;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class SupportTypeUtil {

    @Inject
    private SaveFieldsTransition saveFieldsTransition;

    @Inject
    private DecisionRoundStateTransition decisionRoundStateTransition;

    public StateMachine getCaseStateMachine(CaseEntity caseEntity) {
        Map<DecisionRoundState, Map<Trigger, Transition>> stateMap = getStateMapForSupportType( caseEntity.getSupportTypeNode());
        return createStateMachine(caseEntity, stateMap);
    }

    protected Map<DecisionRoundState, Map<Trigger, Transition>> getStateMapForSupportType(SupportTypeNode supportTypeNode) {

        Map<DecisionRoundState, Map<Trigger, Transition>> stateMap =
                Map.of(
                        new DecisionRoundState(CaseDecisionType.APPLICATION_APPROVAL, CaseStatus.UNDER_DECISION),
                        Map.of(Trigger.SAVE_FIELDS, saveFieldsTransition,
                               Trigger.SUGGEST_DECISION, saveFieldsTransition),

                        new DecisionRoundState(CaseDecisionType.APPLICATION_APPROVAL, CaseStatus.UNHANDLED),
                        Map.of(Trigger.SAVE_FIELDS, saveFieldsTransition,
                                Trigger.SUGGEST_DECISION, saveFieldsTransition),

                        new DecisionRoundState(CaseDecisionType.PAYMENT_REQUEST, CaseStatus.UNDER_DECISION),
                        Map.of(Trigger.SAVE_FIELDS, saveFieldsTransition),

                        new DecisionRoundState(CaseDecisionType.APPLICATION_APPROVAL, CaseStatus.UNDER_PREPARATION),
                        Map.of(Trigger.NEXT_DECISION_ROUND_STATE, decisionRoundStateTransition),

//                        new DecisionRoundState(CaseDecisionType.APPLICATION_APPROVAL, CaseStatus.UNDER_DECISION),
//                        Map.of(Trigger.NEXT_DECISION_ROUND_STATE, decisionRoundStateTransition),

                        new DecisionRoundState(CaseDecisionType.APPLICATION_APPROVAL, CaseStatus.UNDER_DISPATCH),
                        Map.of(Trigger.NEXT_DECISION_ROUND_STATE, decisionRoundStateTransition));


        return stateMap;
    }

    public Map<DecisionRoundState, DecisionRoundState> getNextDecisionRoundStateMap() {
        return Map.of(
                new DecisionRoundState(CaseDecisionType.APPLICATION_APPROVAL, CaseStatus.UNDER_PREPARATION),
                new DecisionRoundState(CaseDecisionType.APPLICATION_APPROVAL, CaseStatus.UNDER_DECISION),

                new DecisionRoundState(CaseDecisionType.APPLICATION_APPROVAL, CaseStatus.UNDER_DECISION),
                new DecisionRoundState(CaseDecisionType.APPLICATION_APPROVAL, CaseStatus.UNDER_DISPATCH),

                new DecisionRoundState(CaseDecisionType.APPLICATION_APPROVAL, CaseStatus.UNDER_DISPATCH),
                new DecisionRoundState(CaseDecisionType.NONE, CaseStatus.IN_WAITING));


    }

    protected StateMachine createStateMachine(CaseEntity caseEntity, Map<DecisionRoundState, Map<Trigger, Transition>> stateMap) {
//        //TODO if techName== XXX return new DefaultStateMachine ... etc
//        SupportTypeNode supportTypeNode = caseEntity.getSupportTypeNode();
//        String techName = caseEntity.getSupportTypeNode().getTechName();

        return new DefaultStateMachine(caseEntity, stateMap);
    }
}
