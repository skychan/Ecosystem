/**
 * 
 * This file was automatically generated by the Repast Simphony Agent Editor.
 * Please see http://repast.sourceforge.net/ for details.
 * 
 */

/**
 *
 * Set the package name.
 *
 */
package ecosystem

/**
 *
 * Import the needed packages.
 *
 */
import java.io.*
import java.math.*
import java.util.*
import javax.measure.unit.*
import org.jscience.mathematics.number.*
import org.jscience.mathematics.vector.*
import org.jscience.physics.amount.*
import repast.simphony.adaptation.neural.*
import repast.simphony.adaptation.regression.*
import repast.simphony.context.*
import repast.simphony.context.space.continuous.*
import repast.simphony.context.space.gis.*
import repast.simphony.context.space.graph.*
import repast.simphony.context.space.grid.*
import repast.simphony.engine.environment.*
import repast.simphony.engine.schedule.*
import repast.simphony.engine.watcher.*
import repast.simphony.groovy.math.*
import repast.simphony.integration.*
import repast.simphony.matlab.link.*
import repast.simphony.query.*
import repast.simphony.query.space.continuous.*
import repast.simphony.query.space.gis.*
import repast.simphony.query.space.graph.*
import repast.simphony.query.space.grid.*
import repast.simphony.query.space.projection.*
import repast.simphony.parameter.*
import repast.simphony.random.*
import repast.simphony.space.continuous.*
import repast.simphony.space.gis.*
import repast.simphony.space.graph.*
import repast.simphony.space.grid.*
import repast.simphony.space.projection.*
import repast.simphony.ui.probe.*
import repast.simphony.util.*
import simphony.util.messages.*
import static java.lang.Math.*
import static repast.simphony.essentials.RepastEssentials.*

/**
 *
 * This is an agent.
 *
 */
public class Denamder extends ecosystem.User  {

    /**
     *
     * Task data read from file
     * @field taskMap
     *
     */
    @Parameter (displayName = "Task Map", usageName = "taskMap")
    public def getTaskMap() {
        return taskMap
    }
    public void setTaskMap(def newValue) {
        taskMap = newValue
    }
    public def taskMap = [:]

    /**
     *
     * This value is used to automatically generate agent identifiers.
     * @field serialVersionUID
     *
     */
    private static final long serialVersionUID = 1L

    /**
     *
     * This value is used to automatically generate agent identifiers.
     * @field agentIDCounter
     *
     */
    protected static long agentIDCounter = 1

    /**
     *
     * This value is the agent's identifier.
     * @field agentID
     *
     */
    protected String agentID = "Denamder " + (agentIDCounter++)

    /**
     *
     * Read data from file
     * @method ReadData
     *
     */
    public def ReadData(String orderID) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        Scanner sc = new Scanner(new File("cases/Order"+orderID+".rcp"))
        int nTasks = sc.nextInt()
        int nServices = sc.nextInt()
        sc.nextLine()
        sc.nextLine()

        // This is a loop.
        for (int i in 1..nTasks) {

            // This is a task.
            def templist = [:]
            templist << [p:sc.nextInt()]

            // This is a loop.
            for (int j in 1..nServices) {

                // This is a task.
                int amount = sc.nextInt()

                // This is an agent decision.
                if (amount > 0) {

                    // This is a task.
                    templist << [(j):amount]

                } else  {


                }

            }

            // This is a task.
            this.taskMap << [(i): templist]
            int nSuccessor = sc.nextInt()

            // This is a loop.
            for (int s in 0..<nSuccessor) {

                // This is a task.
                sc.nextInt()

            }


        }

        // This is a task.
        // Return the results.
        return returnValue

    }

    /**
     *
     * This method provides a human-readable name for the agent.
     * @method toString
     *
     */
    @ProbeID()
    public String toString() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // Set the default agent identifier.
        returnValue = this.agentID
        // Return the results.
        return returnValue

    }


}

