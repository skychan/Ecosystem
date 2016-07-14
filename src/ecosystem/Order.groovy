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
    public ArrayList getOwnerList() {
        return ownerList
    }
    public void setOwnerList(ArrayList newValue) {
        ownerList = newValue
    }
    public ArrayList ownerList = new ArrayList()

    /**
     *
     * The order amount
     * @field amount
     *
     */
    @Parameter (displayName = "Amount", usageName = "amount")
    public int getAmount() {
        return amount
    }
    public void setAmount(int newValue) {
        amount = newValue
    }
    public int amount = 0

    /**
     *
     * Record the allocated service
     * @field allocatedService
     *
     */
    @Parameter (displayName = "Service", usageName = "allocatedService")
    public Service getAllocatedService() {
        return allocatedService
    }
    public void setAllocatedService(Service newValue) {
        allocatedService = newValue
    }
    public Service allocatedService = null

    /**
     *
     * Record the candidates
     * @field candidates
     *
     */
    @Parameter (displayName = "Candidates", usageName = "candidates")
    public def getCandidates() {
        return candidates
    }
    public void setCandidates(def newValue) {
        candidates = newValue
    }
    public def candidates = []

    /**
     *
     * Record the current owner
     * @field owner
     *
     */
    @Parameter (displayName = "Current owner", usageName = "owner")
    public def getOwner() {
        return owner
    }
    public void setOwner(def newValue) {
        owner = newValue
    }
    public def owner = null

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
    public void addOwner(Object od) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // add owner to the list
        this.getOwnerList().add(od)
    }

    /**
     *
     * Chose the provider
     * @method Select
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.Service',
        watcheeFieldNames = 'compete',
        triggerCondition = '$watchee.getCompete().toString() == $watcher.toString()',
        whenToTrigger = WatcherTriggerSchedule.LATER,
        scheduleTriggerDelta = 0.1d,
        scheduleTriggerPriority = -1.7976931348623157E308d
    )
    public def Select(ecosystem.Service watchedAgent) {

        // This is a task.
        this.setAllocatedService(this.getCandidates().remove(0))
        this.getAllocatedService().getJobList().add(this)
        System.out.println(this.getAllocatedService().getJobList())

        // This is a loop.
        for (Service s in this.candidates) {

            // This is a task.
            s.setCompete(false)

        }

        // This is a task.
        this.candidates.clear()
        this.allocatedService.setCompete(false)
        System.out.println("Chosed provider")
        this.getOwner().setNeed(false)
    }

    /**
     *
     * Add the competitor
     * @method AddCompetitor
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.Service',
        watcheeFieldNames = 'compete',
        triggerCondition = '$watchee.getCompete().toString() == $watcher.toString()',
        whenToTrigger = WatcherTriggerSchedule.LATER,
        scheduleTriggerDelta = 0.1d,
        scheduleTriggerPriority = 1.7976931348623157E308d
    )
    public def AddCompetitor(ecosystem.Service watchedAgent) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // Add to the temp candidates list
        this.candidates << watchedAgent
        System.out.println("add competitor")
        System.out.println(watchedAgent.getCompete())
        println candidates
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

