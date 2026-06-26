BEGIN
    FOR customer_rec IN (
        SELECT CustomerID, DOB
        FROM Customers
    )
    LOOP
        -- Check if customer's age is greater than 60
        IF TRUNC(MONTHS_BETWEEN(SYSDATE, customer_rec.DOB) / 12) > 60 THEN

            -- Apply a 1% discount to the customer's loan interest rate
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = customer_rec.CustomerID;

            -- Display a confirmation message
            DBMS_OUTPUT.PUT_LINE(
                '1% discount applied to Customer ID: '
                || customer_rec.CustomerID
            );

        END IF;
    END LOOP;

    COMMIT;
END;
/

