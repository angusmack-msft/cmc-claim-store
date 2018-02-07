package uk.gov.hmcts.cmc.ccd.domain;

public enum CaseEvent {

    SUBMIT_CLAIM("submitClaimEvent"),
    DEFAULT_CCJ_REQUESTED("DefaultCCJRequested"),
    MORE_TIME_REQUESTED("MoreTimeRequested");

    private String value;

    CaseEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
