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
public class Machine  {

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
     * @field responseBehavior
     *
     */
    @Parameter (displayName = "ResponseBehavior", usageName = "responseBehavior")
    public ResponseBehavior getResponseBehavior() {
        return responseBehavior
    }
    public void setResponseBehavior(ResponseBehavior newValue) {
        responseBehavior = newValue
    }
    public ResponseBehavior responseBehavior = null

    /**
     *
     * This is an agent property.
     * @field CompeteList
     *
     */
    @Parameter (displayName = "Compete List", usageName = "CompeteList")
    public def getCompeteList() {
        return CompeteList
    }
    public void setCompeteList(def newValue) {
        CompeteList = newValue
    }
    public def CompeteList = []

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
     * Quality mu
     * @field mu
     *
     */
    @Parameter (displayName = "Quality mu", usageName = "mu")
    public double getMu() {
        return mu
    }
    public void setMu(double newValue) {
        mu = newValue
    }
    public double mu = 0

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
     * This is the task buffer
     * @field buffer
     *
     */
    @Parameter (displayName = "Buffer", usageName = "buffer")
    public List getBuffer() {
        return buffer
    }
    public void setBuffer(List newValue) {
        buffer = newValue
    }
    public List buffer = []

    /**
     *
     * This is an agent property.
     * @field shiftTask
     *
     */
    @Parameter (displayName = "Shift Task", usageName = "shiftTask")
    public def getShiftTask() {
        return shiftTask
    }
    public void setShiftTask(def newValue) {
        shiftTask = newValue
    }
    public def shiftTask = []

    /**
     *
     * This is an agent property.
     * @field chosenTime
     *
     */
    @Parameter (displayName = "Chosen time", usageName = "chosenTime")
    public double getChosenTime() {
        return chosenTime
    }
    public void setChosenTime(double newValue) {
        chosenTime = newValue
    }
    public double chosenTime = 0

    /**
     *
     * This is an agent property.
     * @field assignBehavior
     *
     */
    @Parameter (displayName = "Assign Behavior", usageName = "assignBehavior")
    public AssignBehavior getAssignBehavior() {
        return assignBehavior
    }
    public void setAssignBehavior(AssignBehavior newValue) {
        assignBehavior = newValue
    }
    public AssignBehavior assignBehavior = null

    /**
     *
     * This is an agent property.
     * @field releaseBehavior
     *
     */
    @Parameter (displayName = "Release Behavior", usageName = "releaseBehavior")
    public ReleaseBehavior getReleaseBehavior() {
        return releaseBehavior
    }
    public void setReleaseBehavior(ReleaseBehavior newValue) {
        releaseBehavior = newValue
    }
    public ReleaseBehavior releaseBehavior = null

    /**
     *
     * Record the owners of the task
     * @field owner
     *
     */
    @Parameter (displayName = "Owner", usageName = "owner")
    public ecosystem.Provider getOwner() {
        return owner
    }
    public void setOwner(ecosystem.Provider newValue) {
        owner = newValue
    }
    public ecosystem.Provider owner = null

    /**
     *
     * Job list
     * @field jobList
     *
     */
    @Parameter (displayName = "Job List", usageName = "jobList")
    public List getJobList() {
        return jobList
    }
    public void setJobList(List newValue) {
        jobList = newValue
    }
    public List jobList = []

    /**
     *
     * This is an agent property.
     * @field responseList
     *
     */
    @Parameter (displayName = "Response List", usageName = "responseList")
    public List getResponseList() {
        return responseList
    }
    public void setResponseList(List newValue) {
        responseList = newValue
    }
    public List responseList = []

    /**
     *
     * Quality sigma
     * @field sigma
     *
     */
    @Parameter (displayName = "Quality sigma", usageName = "sigma")
    public double getSigma() {
        return sigma
    }
    public void setSigma(double newValue) {
        sigma = newValue
    }
    public double sigma = 0

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
    protected String agentID = "Machine " + (agentIDCounter++)

    /**
     *
     * Response to the need call
     * @method Response
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.Task',
        watcheeFieldNames = 'inNeed',
        triggerCondition = '$watchee.getInNeed()',
        whenToTrigger = WatcherTriggerSchedule.IMMEDIATE
    )
    public void Response(ecosystem.Task watchedAgent) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // Decide to take the task or not
        if (true ) {


            // This is an agent decision.
            if (responseBehavior.Exist(watchedAgent,this)) {

                // change the compete state
                this.responseList << watchedAgent

            } else  {


            }

        } else  {


        }
    }

    /**
     *
     * Change the service rank with depends on the review
     * @method getRank
     *
     */
    public def getRank() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        Provider user = this.owner[-1]
        returnValue = user.getRank()
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
        //println "add demander's review to the history"
        this.reviews << rvalue
        // Return the results.
        return returnValue

    }

    /**
     *
     * Review and comment after the task is finished
     * @method Review
     *
     */
    public def Review(theTask) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        double q = theTask.getProductQuality()
        int t = theTask.responseTime[this]
        double h = theTask.getHardness()
        int p = theTask.getProcessingTime()
        this.reviews <<  (h * q / (t+p))
        // This is a task.
        this.owner.addTaskFrequency(theTask)
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method getFullLength
     *
     */
    public int getFullLength() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        returnValue = this.jobList.size() + this.buffer.size()
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method Assign
     *
     */
    public void Assign(Task job) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.

        // This is an agent decision.
        if (this.assignBehavior.BufferEnterance(job,this)) {

            // This is a task.
            this.assignBehavior.Buffer(job,this)

        } else  {

            // This is a task.
            this.assignBehavior.Queue(job,this)

        }
    }

    /**
     *
     * This is the step behavior.
     * @method Release
     *
     */
    public void Release(job) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        releaseBehavior.Release(job,this)

        // This is an agent decision.
        if (this.jobList.size() > 0) {

            // This is a task.
            releaseBehavior.Next(this)

        } else  {


        }
    }

    /**
     *
     * This is the step behavior.
     * @method Reply
     *
     */
    public void Reply(taskReplyList) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is a loop.
        for (job in taskReplyList) {

            // change the compete state
            this.competeList << job
            job.addCandidates(this)

        }

        // This is a task.
        def scList = competeList.findAll{ it-> it.getClass() == ecosystem.ServiceCall }
        this.responseList = []
    }

    /**
     *
     * Response to the need call
     * @method Reply
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.Job',
        watcheeFieldNames = 'inNeed',
        whenToTrigger = WatcherTriggerSchedule.LATER,
        scheduleTriggerDelta = 0.1d
    )
    public void Reply(ecosystem.Job watchedAgent) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (this.responseList.size() > 0) {


            // This is an agent decision.
            if (this.responseList.findIndexOf{ it.getClass() == ecosystem.ServiceCall } == -1) {

                // This is a task.
                this.Reply(this.responseList)

            } else  {

                // This is a task.
                def scList = this.responseList.findAll{ it-> it.getClass() == ecosystem.ServiceCall }
                // sort the scList
                def theCall = scList[0]
                List taskReplyList = this.responseList.findAll{ it -> it.getClass() == ecosystem.Task }
                taskReplyList = taskReplyList.findAll{it -> it.needResourceCapacity[this.getType()]  <= this.getSourceable() - theCall.needResourceCapacity[this.getType()] }
                // change the compete state
                taskReplyList = [theCall] + taskReplyList
                this.Reply(taskReplyList)

            }

        } else  {


        }
    }

    /**
     *
     * This is the step behavior.
     * @method Finish
     *
     */
    public void Finish(resConf) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        this.owner.addTaskFrequency(resConf)
    }

    /**
     *
     * This is the step behavior.
     * @method getQueueLength
     *
     */
    public int getQueueLength() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        returnValue = this.jobList.size()
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method getQuality
     *
     */
    public def getQuality() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        RandomHelper.createNormal(this.mu,this.sigma)
        returnValue = RandomHelper.getNormal().nextDouble()
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

