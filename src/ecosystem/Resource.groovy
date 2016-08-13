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
public class Resource extends ecosystem.Machine  {

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
    public int available = 0

    /**
     *
     * Record the master of the resource
     * @field master
     *
     */
    @Parameter (displayName = "Master", usageName = "master")
    public Service getMaster() {
        return master
    }
    public void setMaster(Service newValue) {
        master = newValue
    }
    public Service master = null

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
    public PureProvider getOwner() {
        return owner
    }
    public void setOwner(PureProvider newValue) {
        owner = newValue
    }
    public PureProvider owner = null

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
     * Quality
     * @field quality
     *
     */
    @Parameter (displayName = "Quality", usageName = "quality")
    public double getQuality() {
        return quality
    }
    public void setQuality(double newValue) {
        quality = newValue
    }
    public double quality = 0

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
     * This is the task buffer
     * @field buffer
     *
     */
    @Parameter (displayName = "Buffer", usageName = "buffer")
    public def getBuffer() {
        return buffer
    }
    public void setBuffer(def newValue) {
        buffer = newValue
    }
    public def buffer = []

    /**
     *
     * Mark queue in joblist or not
     * @field queue
     *
     */
    @Parameter (displayName = "Queue Status", usageName = "queue")
    public boolean getQueue() {
        return queue
    }
    public void setQueue(boolean newValue) {
        queue = newValue
    }
    public boolean queue = false

    /**
     *
     * This is an agent property.
     * @field queueLength
     *
     */
    @Parameter (displayName = "Queue Length", usageName = "queueLength")
    public int getQueueLength() {
        return queueLength
    }
    public void setQueueLength(int newValue) {
        queueLength = newValue
    }
    public int queueLength = 0

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
     * The var to record compete service
     * @field competeService
     *
     */
    @Parameter (displayName = "Compete service", usageName = "competeService")
    public def getCompeteService() {
        return competeService
    }
    public void setCompeteService(def newValue) {
        competeService = newValue
    }
    public def competeService = []

    /**
     *
     * This is an agent property.
     * @field sourceable
     *
     */
    @Parameter (displayName = "Source-able", usageName = "sourceable")
    public int getSourceable() {
        return sourceable
    }
    public void setSourceable(int newValue) {
        sourceable = newValue
    }
    public int sourceable = 0

    /**
     *
     * The var to record compete service temp
     * @field competeServiceTemp
     *
     */
    @Parameter (displayName = "Compete service temp", usageName = "competeServiceTemp")
    public def getCompeteServiceTemp() {
        return competeServiceTemp
    }
    public void setCompeteServiceTemp(def newValue) {
        competeServiceTemp = newValue
    }
    public def competeServiceTemp = []

    /**
     *
     * This is an agent property.
     * @field serviceNeedCapacity
     *
     */
    @Parameter (displayName = "Service need cap", usageName = "serviceNeedCapacity")
    public int getServiceNeedCapacity() {
        return serviceNeedCapacity
    }
    public void setServiceNeedCapacity(int newValue) {
        serviceNeedCapacity = newValue
    }
    public int serviceNeedCapacity = 0

    /**
     *
     * This is an agent property.
     * @field serviceProvider
     *
     */
    @Parameter (displayName = "Service Provider", usageName = "serviceProvider")
    public def getServiceProvider() {
        return serviceProvider
    }
    public void setServiceProvider(def newValue) {
        serviceProvider = newValue
    }
    public def serviceProvider = 0

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
     * @method Release
     *
     */
    public void Release(int amount) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (this.getServiceNeedCapacity() > 0) {


            // This is an agent decision.
            if (amount >= this.getServiceNeedCapacity()) {

                // This is a task.
                amount -= this.getServiceNeedCapacity()
                this.setServiceNeedCapacity(0)
                this.serviceProvider.serviceStatus[this] = true
                this.serviceProvider.setServiceReady(true)
                // This is a task.
                int temp = this.getAvailable()
                temp += amount
                this.setAvailable(temp)

            } else  {

                // This is a task.
                amount = 0
                this.setServiceNeedCapacity(this.getServiceNeedCapacity() - amount)

            }

        } else  {


        }
    }

    /**
     *
     * Response to the need call
     * @method Response
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.Task',
        watcheeFieldNames = 'inNeed',
        triggerCondition = '$watchee.Exist($watcher.getType()) && $watchee.inNeed',
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
            this.compete << watchedAgent
            watchedAgent.addCandidates(this)
            //println this.toString() + " compete " + watchedAgent.toString()

        } else  {


        }
        // Return the results.
        return returnValue

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
        PureProvider user = this.owner[-1]
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
     * Check if a task in the compete list
     * @method Exist
     *
     */
    public boolean Exist(checkList, tester) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        returnValue = (tester in checkList)
        // Return the results.
        return returnValue

    }

    /**
     *
     * Chosen process
     * @method Chosen
     *
     */
    public def Chosen(theOne) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        this.compete.remove(theOne)

        // This is an agent decision.
        if (this.getAvailable() < theOne.needResourceCapacity[this.getType()]) {

            // This is a task.
            this.jobList << theOne
            println this.toString() + " jobList " + this.jobList
            println this.toString() + " buffer " + this.buffer
            println this.toString() + " readytask " + this.readyTask
            this.queueLength += 1
            this.setQueue(true)
            println this.toString() + " with type "+ this.getType()+ " queue length=" + this.getQueueLength()

        } else  {

            // This is a task.
            this.buffer << theOne
            this.setAvailable(this.getAvailable()-theOne.needResourceCapacity[this.getType()])
            theOne.prepareStatus[this.getType()] = true
            double t = RunEnvironment.getInstance().getCurrentSchedule().getTickCount()
            int delta =  t - theOne.getChosenTime()
            theOne.responseTime[this] = delta
            theOne.inBufferTime[this] = t
            println this.toString() + " jobList " + this.jobList
            println this.toString() + " buffer " + this.buffer
            println this.toString() + " readytask " + this.readyTask

        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * Chose the next task
     * @method Next
     *
     */
    public def Next() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is a loop.
        for (theOne in this.jobList) {


            // This is an agent decision.
            if (this.getAvailable() >= theOne.needResourceCapacity[this.getType()]) {

                // This is a task.
                this.buffer << theOne
                this.setAvailable(this.getAvailable()-theOne.needResourceCapacity[this.getType()])
                theOne.prepareStatus[this.getType()] = true
                this.shiftTask << theOne
                this.setQueue(false)
                // This is a task.
                this.queueLength -= 1
                println this.toString() + " with type "+ this.getType()+ " queue length=" + this.getQueueLength()
                double t = RunEnvironment.getInstance().getCurrentSchedule().getTickCount()
                int delta = t - theOne.getChosenTime()
                theOne.responseTime[this] = delta
                theOne.inBufferTime[this] = t

            } else  {


            }

        }


        // This is a loop.
        for (theOne in this.shiftTask) {

            // This is a task.
            this.jobList.remove(theOne)

        }

        // This is a task.
        this.shiftTask = []
        this.owner[0].ServiceCall()
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
        returnValue = this.jobList.size() + this.buffer.size() + this.readyTask.size()
        // Return the results.
        return returnValue

    }

    /**
     *
     * Response to the need call
     * @method ResponseServiceCall
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.PureProvider',
        watcheeFieldNames = 'serviceCalling',
        triggerCondition = '$watcher.serviceNeedCapacity == 0',
        whenToTrigger = WatcherTriggerSchedule.LATER,
        scheduleTriggerDelta = 0.1d
    )
    public def ResponseServiceCall(ecosystem.PureProvider watchedAgent) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // Decide to take the task or not
        if (true) {


            // This is an agent decision.
            if (this.getSourceable() > 0) {


                // This is an agent decision.
                if (this.getType() in watchedAgent.callContent.keySet()) {

                    // This is a task.
                    this.competeServiceTemp << watchedAgent

                } else  {


                }

            } else  {


            }

        } else  {


        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * Response to the need call
     * @method ResponseService
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.PureProvider',
        watcheeFieldNames = 'serviceCalling',
        triggerCondition = '$watcher.serviceNeedCapacity == 0',
        whenToTrigger = WatcherTriggerSchedule.LATER,
        scheduleTriggerDelta = 0.2d
    )
    public def ResponseService(ecosystem.PureProvider watchedAgent) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (this.getSourceable() > 0) {


            // This is an agent decision.
            if (this.getType() in watchedAgent.callContent.keySet()) {

                // This is a task.
                int tempCap = this.getSourceable()
                int i = 0
                Evaluation(this.competeServiceTemp)

                // This is a loop.
                while (tempCap > 0) {

                    // This is a task.
                    this.competeService << this.competeServiceTemp[i]
                    i += 1
                    tempCap -= this.competeServiceTemp[i].callContent[this.getType()]

                    // This is an agent decision.
                    if (i == this.competeServiceTemp.size()-1) {

                        // This is a task.
                        break

                    } else  {


                    }

                }

                // This is a task.
                this.competeServiceTemp = []

                // This is a loop.
                for (prd in this.competeService) {

                    // This is a task.
                    prd.addCandidates(this)

                }

                // This is a task.
                this.competeService = []

            } else  {


            }

        } else  {


        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * Provider Evaluation
     * @method Evaluation
     *
     */
    public def Evaluation(providerList) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        providerList.sort{[-it.getRank()]}
        // Return the results.
        return returnValue

    }

    /**
     *
     * Ready to join
     * @method Join
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.Resource',
        watcheeFieldNames = 'sourceable',
        triggerCondition = '$watcher.toString() == $watchee.toString()',
        whenToTrigger = WatcherTriggerSchedule.IMMEDIATE
    )
    public def Join(ecosystem.Resource watchedAgent) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (this.getAvailable() >= this.getServiceNeedCapacity()) {

            // This is a task.
            this.setAvailable(this.getAvailable() - this.getServiceNeedCapacity())
            this.serviceProvider.serviceStatus[this] = true
            this.serviceProvider.setServiceReady(true)
            this.setServiceNeedCapacity(0)

        } else  {

            // This is a task.
            this.setServiceNeedCapacity(this.getServiceNeedCapacity() - this.getAvailable())
            this.setAvailable(0)

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

