package uk.gov.hmcts.cmc.claimstore.documents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gov.hmcts.cmc.claimstore.config.properties.pdf.DocumentTemplates;
import uk.gov.hmcts.cmc.claimstore.services.staff.content.DefendantPinLetterContentProvider;
import uk.gov.hmcts.cmc.domain.models.Claim;
import uk.gov.hmcts.reform.pdf.service.client.PDFServiceClient;

import static java.util.Objects.requireNonNull;

@Service
public class DefendantPinLetterPdfService {

    private final DocumentTemplates documentTemplates;
    private final PDFServiceClient pdfServiceClient;
    private final DefendantPinLetterContentProvider defendantPinLetterContentProvider;

    @Autowired
    public DefendantPinLetterPdfService(
        DocumentTemplates documentTemplates,
        PDFServiceClient pdfServiceClient,
        DefendantPinLetterContentProvider defendantPinLetterContentProvider
    ) {
        this.documentTemplates = documentTemplates;
        this.pdfServiceClient = pdfServiceClient;
        this.defendantPinLetterContentProvider = defendantPinLetterContentProvider;
    }

    public byte[] createPdf(Claim claim, String defendantPin) {
        requireNonNull(claim);
        requireNonNull(defendantPin);

        return pdfServiceClient.generateFromHtml(
            documentTemplates.getDefendantPinLetter(),
            defendantPinLetterContentProvider.createContent(claim, defendantPin)
        );
    }
}
