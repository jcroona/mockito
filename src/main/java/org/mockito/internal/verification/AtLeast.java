/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */

package org.mockito.internal.verification;

import static org.mockito.internal.verification.checkers.AtLeastXNumberOfInvocationsChecker.checkAtLeastNumberOfInvocations;
import static org.mockito.internal.verification.checkers.MissingInvocationChecker.checkMissingInvocation;

import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.internal.verification.api.VerificationDataInOrder;
import org.mockito.internal.verification.api.VerificationInOrderMode;
import org.mockito.verification.VerificationMode;

import org.coveragetracking.*;

public class AtLeast implements VerificationInOrderMode, VerificationMode {

    final int wantedCount;

    public AtLeast(int wantedNumberOfInvocations) {
        if (wantedNumberOfInvocations < 0) {
            Coverage.AtLeastCoverage[0] = true;
            throw new MockitoException("Negative value is not allowed here");
        }
        this.wantedCount = wantedNumberOfInvocations;
        Coverage.AtLeastCoverage[1] = true;
    }

    @Override
    public void verify(VerificationData data) {
        if (wantedCount == 1) {
            Coverage.AtLeastCoverage[2] = true;
             checkMissingInvocation(data.getAllInvocations(), data.getTarget());
        }
        Coverage.AtLeastCoverage[3] = true;
        checkAtLeastNumberOfInvocations(data.getAllInvocations(), data.getTarget(), wantedCount);
    }

    @Override
    public void verifyInOrder(VerificationDataInOrder data) {
        if (wantedCount == 1) {
            Coverage.AtLeastCoverage[4] = true;
             checkMissingInvocation(data.getAllInvocations(), data.getWanted(),  data.getOrderingContext());
        }
        Coverage.AtLeastCoverage[5] = true;
        checkAtLeastNumberOfInvocations(data.getAllInvocations(), data.getWanted(), wantedCount, data.getOrderingContext());
    }

    @Override
    public String toString() {
        Coverage.AtLeastCoverage[6] = true;
        return "Wanted invocations count: at least " + wantedCount;
    }

    @Override
    public VerificationMode description(String description) {
        Coverage.AtLeastCoverage[7] = true;
        return VerificationModeFactory.description(this, description);
    }
}
