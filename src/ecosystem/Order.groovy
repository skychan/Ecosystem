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
 * This is order agent.
 *
 */
public class Order  {

    /**
     *
     * This is an agent property.
     * @field taskList
     *
     */
    @Parameter (displayName = "TaskList", usageName = "taskList")
    public List<Task> getTaskList() {
        return taskList
    }
    public void setTaskList(List<Task> newValue) {
        taskList = newValue
    }
    public List<Task> taskList = new ArrayList<Task>()

    /**
     *
     * Task Status
     * @field status
     *
     */
    @Parameter (displayName = "Order Status", usageName = "status")
    public HashMap<String,Boolean> getStatus() {
        return status
    }
    public void setStatus(HashMap<String,Boolean> newValue) {
        status = newValue
    }
    public HashMap<String,Boolean> status = new HashMap<String,Boolean>()

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
    protected String agentID = "Order " + (agentIDCounter++)

    /**
     *
     * This is the step behavior.
     * @method Add
     *
     */
    public void Add(Task t) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        this.taskList.add(t)
        this.status.put(t.toString(),false)
    }

    /**
     *
     * when one task finished, turn the status to true
     * @method Change
     *
     */
    public void Change(String taskID) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // Update the tasks' status
        this.status.replace(taskID,true)
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

