package org.andjos.susfund.statemachine.util;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import org.andjos.susfund.entity.caseentity.CaseDecisionType;
import org.andjos.susfund.entity.caseentity.CaseEntity;
import org.andjos.susfund.entity.caseentity.CaseStatus;
import org.andjos.susfund.entity.supporttype.SupportTypeNode;
import org.andjos.susfund.statemachine.DefaultStateMachine;
import org.andjos.susfund.statemachine.StateMachine;
import org.andjos.susfund.statemachine.state.DecisionRoundState;
import org.andjos.susfund.statemachine.transition.SaveFieldsTransition;
import org.andjos.susfund.statemachine.transition.Transition;
import org.andjos.susfund.statemachine.trigger.Trigger;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class SupportTypeUtil {

    @Inject
    Instance<SaveFieldsTransition> saveFieldsTransitionProvider;

    public StateMachine getCaseStateMachine(CaseEntity caseEntity) {
        Map<DecisionRoundState, Map<Trigger, Transition>> stateMap = getStateMapForSupportType( caseEntity.getSupportTypeNode());
        return createStateMachine(caseEntity, stateMap);
    }

    protected Map<DecisionRoundState, Map<Trigger, Transition>> getStateMapForSupportType(SupportTypeNode supportTypeNode) {

        Map<DecisionRoundState, Map<Trigger, Transition>> stateMap =
                Map.of(
                        new DecisionRoundState(CaseDecisionType.APPLICATION_APPROVAL, CaseStatus.UNDER_SUPPORT_DECISION),
                        Map.of(Trigger.SAVE_FIELDS, saveFieldsTransitionProvider.get(),
                               Trigger.SUGGEST_DECISION, saveFieldsTransitionProvider.get()),



                        new DecisionRoundState(CaseDecisionType.PAYMENT_REQUEST, CaseStatus.UNDER_PAYMENT_DECISION),
                        Map.of(Trigger.SAVE_FIELDS, saveFieldsTransitionProvider.get()),

                        new DecisionRoundState(CaseDecisionType.APPLICATION_APPROVAL, CaseStatus.UNHANDLED),
                        Map.of(Trigger.SAVE_FIELDS, saveFieldsTransitionProvider.get())

                );

        return stateMap;
    }

    protected StateMachine createStateMachine(CaseEntity caseEntity, Map<DecisionRoundState, Map<Trigger, Transition>> stateMap) {
//        //TODO if techName== XXX return new DefaultStateMachine ... etc
//        SupportTypeNode supportTypeNode = caseEntity.getSupportTypeNode();
//        String techName = caseEntity.getSupportTypeNode().getTechName();

        return new DefaultStateMachine(caseEntity, stateMap);
    }
}
