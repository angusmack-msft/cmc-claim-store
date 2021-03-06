package uk.gov.hmcts.cmc.claimstore.utils;

import static java.lang.String.format;
import static uk.gov.hmcts.cmc.claimstore.utils.Preconditions.requireNonBlank;

public class DocumentNameUtils {

    private DocumentNameUtils() {
    }

    public static String buildSealedClaimFileBaseName(String number) {
        requireNonBlank(number);

        return format("%s-sealed-claim", number);
    }

    public static boolean isSealedClaim(String filename) {
        requireNonBlank(filename);

        return filename.contains("sealed-claim");
    }

    public static String buildDefendantLetterFileBaseName(String number) {
        requireNonBlank(number);

        return format("%s-defendant-pin-letter", number);
    }

}
