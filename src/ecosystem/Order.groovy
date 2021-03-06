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
     * @field owner
     *
     */
    @Parameter (displayName = "Owner", usageName = "owner")
    public ecosystem.Demander getOwner() {
        return owner
    }
    public void setOwner(ecosystem.Demander newValue) {
        owner = newValue
    }
    public ecosystem.Demander owner = null

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
    public def taskList = [:]

    /**
     *
     * This is an agent property.
     * @field type
     *
     */
    @Parameter (displayName = "Type", usageName = "type")
    public String getType() {
        return type
    }
    public void setType(String newValue) {
        type = newValue
    }
    public String type = ""

    /**
     *
     * This is an agent property.
     * @field plt
     *
     */
    @Parameter (displayName = "Plt", usageName = "plt")
    public def getPlt() {
        return plt
    }
    public void setPlt(def newValue) {
        plt = newValue
    }
    public def plt = 0

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
     * Set the tasks belongs to this order
     * @method setParameters
     *
     */
    public void setParameters(taskMap) {

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
                t.setMaster( this )
                t.setParameters(tdata)
                this.taskList[t] = false
                // This is a task.
                t.setType(this.getType() + "-" + (i).toString())
                i+=1
                this.plt.addNeedCap(t)

            } else  {


            }

        }

        // This is a task.
    }

    /**
     *
     * This is the step behavior.
     * @method Finish
     *
     */
    public void Finish(task) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        this.taskList[task] = true
        RemoveAgentFromModel(task)

        // This is an agent decision.
        if (this.taskList.values().count(false) == 0) {

            // This is a task.
            this.owner.Finish(this)

        } else  {


        }
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

