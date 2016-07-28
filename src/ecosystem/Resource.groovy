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
public class Resource  {

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
     * This is an agent property.
     * @field unitCost
     *
     */
    @Parameter (displayName = "Unit Cost", usageName = "unitCost")
    public int getUnitCost() {
        return unitCost
    }
    public void setUnitCost(int newValue) {
        unitCost = newValue
    }
    public int unitCost = 0

    /**
     *
     * This is an agent property.
     * @field available
     *
     */
    @Parameter (displayName = "Available", usageName = "available")
    public int getAvailable() {
        return available
    }
    public void setAvailable(int newValue) {
        available = newValue
    }
    public int available = this.getCapacity()

    /**
     *
     * Record the master of the resource
     * @field master
     *
     */
    @Parameter (displayName = "Master", usageName = "master")
    public def getMaster() {
        return master
    }
    public void setMaster(def newValue) {
        master = newValue
    }
    public def master = []

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
    public def getOwner() {
        return owner
    }
    public void setOwner(def newValue) {
        owner = newValue
    }
    public def owner = []

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
     * The var to record compete order
     * @field compete
     *
     */
    @Parameter (displayName = "Compete", usageName = "compete")
    public def getCompete() {
        return compete
    }
    public void setCompete(def newValue) {
        compete = newValue
    }
    public def compete = []

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
    public Order getOrder() {
        return order
    }
    public void setOrder(Order newValue) {
        order = newValue
    }
    public Order order = null

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
     * Job list
     * @field jobList
     *
     */
    @Parameter (displayName = "Job List", usageName = "jobList")
    public def getJobList() {
        return jobList
    }
    public void setJobList(def newValue) {
        jobList = newValue
    }
    public def jobList = []

    /**
     *
     * Mark the status of processing or not
     * @field processing
     *
     */
    @Parameter (displayName = "Processing ?", usageName = "processing")
    public boolean getProcessing() {
        return processing
    }
    public void setProcessing(boolean newValue) {
        processing = newValue
    }
    public boolean processing = false

    /**
     *
     * Quality
     * @field quality
     *
     */
    @Parameter (displayName = "Quality", usageName = "quality")
    public def getQuality() {
        return quality
    }
    public void setQuality(def newValue) {
        quality = newValue
    }
    public def quality = 0

    /**
     *
     * Review history
     * @field reviews
     *
     */
    @Parameter (displayName = "Review History", usageName = "reviews")
    public def getReviews() {
        return reviews
    }
    public void setReviews(def newValue) {
        reviews = newValue
    }
    public def reviews = []

    /**
     *
     * Mark the Rank value
     * @field rank
     *
     */
    @Parameter (displayName = "Rank", usageName = "rank")
    public def getRank() {
        return rank
    }
    public void setRank(def newValue) {
        rank = newValue
    }
    public def rank = 0

    /**
     *
     * Record the available capacity
     * @field availablity
     *
     */
    @Parameter (displayName = "Availablity", usageName = "availablity")
    public int getAvailablity() {
        return availablity
    }
    public void setAvailablity(int newValue) {
        availablity = newValue
    }
    public int availablity = this.getCapacity()

    /**
     *
     * The ready mark
     * @field ready
     *
     */
    @Parameter (displayName = "Ready", usageName = "ready")
    public def getReady() {
        return ready
    }
    public void setReady(def newValue) {
        ready = newValue
    }
    public def ready = false

    /**
     *
     * The ready task mark
     * @field readyTask
     *
     */
    @Parameter (displayName = "Ready Task", usageName = "readyTask")
    public def getReadyTask() {
        return readyTask
    }
    public void setReadyTask(def newValue) {
        readyTask = newValue
    }
    public def readyTask = []

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
    protected String agentID = "Resource " + (agentIDCounter++)

    /**
     *
     * This is the step behavior.
     * @method Occupy
     *
     */
    public void Occupy(int amount) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        int temp = this.getAvailable()
        temp -= amount
        this.setAvailable(temp)
    }

    /**
     *
     * This is the step behavior.
     * @method Release
     *
     */
    public void Release(int amount) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        int temp = this.getAvailable()
        temp -= amount
        this.setAvailable(temp)
    }

    /**
     *
     * This is the step behavior.
     * @method Bid
     *
     */
    public void Bid(int cost) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        this.setUnitCost(cost)
    }

    /**
     *
     * Set the owner is add to the owner list
     * @method addMaster
     *
     */
    public void addMaster(masterID) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // add master to the list
        this.master << masterID
    }

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
        this.owner << ownerID
    }

    /**
     *
     * Response to the need call
     * @method Response
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.Task',
        watcheeFieldNames = 'call',
        triggerCondition = '$watcher.type in $watchee.call.keySets()',
        whenToTrigger = WatcherTriggerSchedule.LATER,
        scheduleTriggerDelta = 0.1d
    )
    public def Response(ecosystem.Task watchedAgent) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // Decide to take the task or not
        if (true) {

            // change the compete state
            this.setCompete(watchedAgent)
            println this.toString() + " is competing for "+ compete

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
    @ScheduledMethod(
        start = 1d,
        interval = 1d,
        shuffle = true
    )
    public def Process() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // Have ready tasks or not
        if (this.getReadyTasks().size()>0) {

            // Continue
            System.out.println("continue to process "+this.getOrder().toString())

            // This is a loop.
            for (theTask in this.readyTask) {

                // This is a task.
                theTask.setProcessingTime(theTask.getProcessingTime()-1)

                // Check if the job is finished
                if (theTask.getProcessingTime()<=0) {

                    // The finish step
                    this.setFinish(this.getFinish()+1)
                    System.out.println(theTask.toString()+" Finished")
                    this.getJobList().remove(theTask)
                    this.readyTask.remove(theTask)

                } else  {


                }

            }


        } else  {


        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * Change the service rank with depends on the review
     * @method AdjustRank
     *
     */
    public def AdjustRank() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        // Return the results.
        return returnValue

    }

    /**
     *
     * Add review to history
     * @method AddReview
     *
     */
    public def AddReview(rvalue) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        println "add demander's review to the history"
        this.reviews << rvalue
        // Return the results.
        return returnValue

    }

    /**
     *
     * After select, just wait for other resource to get ready
     * @method Prepare
     *
     */
    public def Prepare(needCapacity) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (this.getAvailablity() < needCapacity) {

            // This is a task.
            this.setReady(false)

        } else  {

            // This is a task.
            this.setReady(true)

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

