package uk.gov.hmcts.cmc.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import uk.gov.hmcts.cmc.domain.models.legalrep.StatementOfTruth;
import uk.gov.hmcts.cmc.domain.models.party.Party;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "response")
@JsonSubTypes(
    {
        @JsonSubTypes.Type(value = PartialAdmissionResponseData.class, name = "OWE_SOME_PAID_NONE"),
        @JsonSubTypes.Type(value = FullDefenceResponseData.class, name = "OWE_NONE"),
    }
)
public class ResponseData {

    public enum FreeMediationOption {
        @JsonProperty("yes")
        YES,
        @JsonProperty("no")
        NO
    }

    public enum MoreTimeNeededOption {
        @JsonProperty("yes")
        YES,
        @JsonProperty("no")
        NO
    }

    @Valid
    @NotNull
    private final Party defendant;

    @Valid
    private final StatementOfTruth statementOfTruth;

    private final FreeMediationOption freeMediation;

    @JsonUnwrapped
    private final MoreTimeNeededOption moreTimeNeeded;

    public ResponseData(
        final FreeMediationOption freeMediation,
        final MoreTimeNeededOption moreTimeNeeded,
        final Party defendant,
        final StatementOfTruth statementOfTruth
    ) {
        this.freeMediation = freeMediation;
        this.moreTimeNeeded = moreTimeNeeded;
        this.defendant = defendant;
        this.statementOfTruth = statementOfTruth;
    }

    @Override
    @SuppressWarnings("squid:S1067") // Its generated code for equals sonar
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        final ResponseData that = (ResponseData) other;
        return Objects.equals(freeMediation, that.freeMediation)
            && Objects.equals(moreTimeNeeded, that.moreTimeNeeded)
            && Objects.equals(defendant, that.defendant)
            && Objects.equals(statementOfTruth, that.statementOfTruth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(freeMediation, moreTimeNeeded, defendant);
    }


    public Optional<FreeMediationOption> getFreeMediation() {
        return Optional.ofNullable(freeMediation);
    }

    public MoreTimeNeededOption getMoreTimeNeeded() {
        return moreTimeNeeded;
    }

    public Party getDefendant() {
        return defendant;
    }

    public Optional<StatementOfTruth> getStatementOfTruth() {
        return Optional.ofNullable(statementOfTruth);
    }

}
