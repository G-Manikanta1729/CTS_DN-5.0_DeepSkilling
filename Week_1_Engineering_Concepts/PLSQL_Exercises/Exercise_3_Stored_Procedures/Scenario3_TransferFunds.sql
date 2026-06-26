CREATE OR REPLACE PROCEDURE TransferFunds
(
    p_sourceAccount      IN NUMBER,
    p_destinationAccount IN NUMBER,
    p_amount             IN NUMBER
)
AS
    v_balance NUMBER;
BEGIN

    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_sourceAccount;

    IF v_balance >= p_amount THEN

        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_sourceAccount;

        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_destinationAccount;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE(
            'Fund transfer completed successfully.'
        );

    ELSE

        DBMS_OUTPUT.PUT_LINE(
            'Insufficient balance. Transfer failed.'
        );

    END IF;

END;
/

-- Execution Of Procedure

BEGIN
    TransferFunds(3,2,1000);
END;
/