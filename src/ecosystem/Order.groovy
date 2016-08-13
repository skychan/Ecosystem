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
     * The order owner, if not only one
     * @field ownerList
     *
     */
    @Parameter (displayName = "Owner List", usageName = "ownerList")
    public def getOwnerList() {
        return ownerList
    }
    public void setOwnerList(def newValue) {
        ownerList = newValue
    }
    public def ownerList = []

    /**
     *
     * Record the task an order contains
     * @field taskList
     *
     */
    @Parameter (displayName = "Task List", usageName = "taskList")
    public def getTaskList() {
        return taskList
    }
    public void setTaskList(def newValue) {
        taskList = newValue
    }
    public def taskList = []

    /**
     *
     * This is an agent property.
     * @field type
     *
     */
    @Parameter (displayName = "Type", usageName = "type")
    public def getType() {
        return type
    }
    public void setType(def newValue) {
        type = newValue
    }
    public def type = 0

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
     * Set the owner is add to the owner list
     * @method addOwner
     *
     */
    public void addOwner(ownerID) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // add owner to the list
        this.ownerList << ownerID
    }

    /**
     *
     * Supplier Evaluation
     * @method Evaluation
     *
     */
    public def Evaluation() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        this.getCandidates().sort{[it.jobList.size(),it.jobList[0]]}
        // Return the results.
        return returnValue

    }

    /**
     *
     * Set the tasks belongs to this order
     * @method setParameters
     *
     */
    public def setParameters(taskMap) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        int i = 1

        // This is a loop.
        for (tdata in taskMap) {


            // This is an agent decision.
            if (tdata.value.size() > 1) {

                // This is a task.
                Object agent = CreateAgent("Ecosystem", "ecosystem.Task")
                Task t = (Task) agent
                t.setParameters(tdata)
                t.addMaster(this)
                this.taskList << t
                // This is a task.
                t.setType(this.getType() + "-" + (i).toString())
                i+=1

            } else  {


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

