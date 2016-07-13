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
public class Service  {

    /**
     *
     * The capacity of the service
     * @field capacity
     *
     */
    @Parameter (displayName = "Capacity", usageName = "capacity")
    public int getCapacity() {
        return capacity
    }
    public void setCapacity(int newValue) {
        capacity = newValue
    }
    public int capacity = 0

    /**
     *
     * The service owner, if not only one
     * @field owner
     *
     */
    @Parameter (displayName = "Owner", usageName = "owner")
    public ArrayList getOwner() {
        return owner
    }
    public void setOwner(ArrayList newValue) {
        owner = newValue
    }
    public ArrayList owner = new ArrayList()

    /**
     *
     * The service unit cost
     * @field cost
     *
     */
    @Parameter (displayName = "Unit Cost", usageName = "cost")
    public int getCost() {
        return cost
    }
    public void setCost(int newValue) {
        cost = newValue
    }
    public int cost = 0

    /**
     *
     * The mark of competence
     * @field compete
     *
     */
    @Parameter (displayName = "Compete", usageName = "compete")
    public boolean getCompete() {
        return compete
    }
    public void setCompete(boolean newValue) {
        compete = newValue
    }
    public boolean compete = false

    /**
     *
     * Record be chose or not
     * @field chose
     *
     */
    @Parameter (displayName = "Chose", usageName = "chose")
    public boolean getChose() {
        return chose
    }
    public void setChose(boolean newValue) {
        chose = newValue
    }
    public boolean chose = false

    /**
     *
     * The Order(Task) mark
     * @field order
     *
     */
    @Parameter (displayName = "Order Mark", usageName = "order")
    public ecosystem.Order getOrder() {
        return order
    }
    public void setOrder(ecosystem.Order newValue) {
        order = newValue
    }
    public ecosystem.Order order = new ecosystem.Order()

    /**
     *
     * The remain task mark
     * @field remain
     *
     */
    @Parameter (displayName = "Remain", usageName = "remain")
    public int getRemain() {
        return remain
    }
    public void setRemain(int newValue) {
        remain = newValue
    }
    public int remain = 0

    /**
     *
     * Count the finished jobs
     * @field finish
     *
     */
    @Parameter (displayName = "Finished", usageName = "finish")
    public int getFinish() {
        return finish
    }
    public void setFinish(int newValue) {
        finish = newValue
    }
    public int finish = 0

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
    protected String agentID = "Service " + (agentIDCounter++)

    /**
     *
     * Set the owner is add to the owner list
     * @method addOwner
     *
     */
    public void addOwner(String ownerID) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // add owner to the list
        this.owner.add(ownerID)
    }

    /**
     *
     * Response to the need call
     * @method Response
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.PureDemander',
        watcheeFieldNames = 'need',
        triggerCondition = '$watchee.getNeed()',
        whenToTrigger = WatcherTriggerSchedule.IMMEDIATE,
        scheduleTriggerDelta = 1d
    )
    public def Response(ecosystem.PureDemander watchedAgent) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // Decide to take the task or not
        if (true) {

            // change the compete state
            this.setCompete(true)

        } else  {


        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * Begin to process
     * @method Process
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.Service',
        watcheeFieldNames = 'remain',
        triggerCondition = '$watcher.toString() == $watchee.toString() && $watchee.getRemain() > 0',
        whenToTrigger = WatcherTriggerSchedule.IMMEDIATE,
        scheduleTriggerDelta = 1d
    )
    public def Process(ecosystem.Service watchedAgent) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // Cut down remain
        this.setRemain(this.getRemain()-this.getCapacity())

        // To judge if the remain still there
        if (this.getRemain()<=0) {


        } else  {

            // The finish step
            this.setRemain(0)
            this.setFinish(this.getFinish()+1)

        }
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

