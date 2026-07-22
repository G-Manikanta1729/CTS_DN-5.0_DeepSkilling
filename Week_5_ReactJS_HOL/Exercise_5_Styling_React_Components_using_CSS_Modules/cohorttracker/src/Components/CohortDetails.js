import styles from "./CohortDetails.module.css";

function CohortDetails({ cohort }) {

    return (

        <div className={styles.box}>

            <h2>{cohort.name}</h2>

            <h3
                style={{
                    color:
                        cohort.status.toLowerCase() === "ongoing"
                            ? "green"
                            : "blue"
                }}
            >
                {cohort.status}
            </h3>

            <dl>

                <dt>Started On</dt>
                <dd>{cohort.startedOn}</dd>

                <dt>Current Coach</dt>
                <dd>{cohort.currentCoach}</dd>

                <dt>Current Trainer</dt>
                <dd>{cohort.currentTrainer}</dd>

            </dl>

        </div>

    );

}

export default CohortDetails;