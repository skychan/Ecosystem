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
public class PureProvider  {

    /**
     *
     * Record the service
     * @field serviceList
     *
     */
    @Parameter (displayName = "Service List", usageName = "serviceList")
    public def getServiceList() {
        return serviceList
    }
    public void setServiceList(def newValue) {
        serviceList = newValue
    }
    public def serviceList = []

    /**
     *
     * The provider difficulty rank value
     * @field rank
     *
     */
    @Parameter (displayName = "Rank", usageName = "rank")
    public double getRank() {
        return rank
    }
    public void setRank(double newValue) {
        rank = newValue
    }
    public double rank = 1000

    /**
     *
     * This is an agent property.
     * @field resourceList
     *
     */
    @Parameter (displayName = "Resource List", usageName = "resourceList")
    public def getResourceList() {
        return resourceList
    }
    public void setResourceList(def newValue) {
        resourceList = newValue
    }
    public def resourceList = []

    /**
     *
     * This is an agent property.
     * @field candidates
     *
     */
    @Parameter (displayName = "Resource candidates", usageName = "candidates")
    public def getCandidates() {
        return candidates
    }
    public void setCandidates(def newValue) {
        candidates = newValue
    }
    public def candidates = []

    /**
     *
     * This is an agent property.
     * @field taskFrequency
     *
     */
    @Parameter (displayName = "Task Frequency", usageName = "taskFrequency")
    public def getTaskFrequency() {
        return taskFrequency
    }
    public void setTaskFrequency(def newValue) {
        taskFrequency = newValue
    }
    public def taskFrequency = [:]

    /**
     *
     * This is an agent property.
     * @field callContent
     *
     */
    @Parameter (displayName = "Call Content", usageName = "callContent")
    public def getCallContent() {
        return callContent
    }
    public void setCallContent(def newValue) {
        callContent = newValue
    }
    public def callContent = [:]

    /**
     *
     * This is an agent property.
     * @field serviceCalling
     *
     */
    @Parameter (displayName = "Service Calling", usageName = "serviceCalling")
    public boolean getServiceCalling() {
        return serviceCalling
    }
    public void setServiceCalling(boolean newValue) {
        serviceCalling = newValue
    }
    public boolean serviceCalling = false

    /**
     *
     * This is an agent property.
     * @field ingredient
     *
     */
    @Parameter (displayName = "Ingredient", usageName = "ingredient")
    public def getIngredient() {
        return ingredient
    }
    public void setIngredient(def newValue) {
        ingredient = newValue
    }
    public def ingredient = [:]

    /**
     *
     * This is an agent property.
     * @field callCandidates
     *
     */
    @Parameter (displayName = "Call canididates", usageName = "callCandidates")
    public def getCallCandidates() {
        return callCandidates
    }
    public void setCallCandidates(def newValue) {
        callCandidates = newValue
    }
    public def callCandidates = [:]

    /**
     *
     * This is an agent property.
     * @field serviceStatus
     *
     */
    @Parameter (displayName = "Record the service status", usageName = "serviceStatus")
    public def getServiceStatus() {
        return serviceStatus
    }
    public void setServiceStatus(def newValue) {
        serviceStatus = newValue
    }
    public def serviceStatus = [:]

    /**
     *
     * This is an agent property.
     * @field serviceReady
     *
     */
    @Parameter (displayName = "Ready mark", usageName = "serviceReady")
    public boolean getServiceReady() {
        return serviceReady
    }
    public void setServiceReady(boolean newValue) {
        serviceReady = newValue
    }
    public boolean serviceReady = false

    /**
     *
     * denote the task type pattern
     * @field callPattern
     *
     */
    @Parameter (displayName = "Call Pattern", usageName = "callPattern")
    public def getCallPattern() {
        return callPattern
    }
    public void setCallPattern(def newValue) {
        callPattern = newValue
    }
    public def callPattern = 0

    /**
     *
     * This is an agent property.
     * @field prototype
     *
     */
    @Parameter (displayName = "Service Prototype", usageName = "prototype")
    public Service getPrototype() {
        return prototype
    }
    public void setPrototype(Service newValue) {
        prototype = newValue
    }
    public Service prototype = null

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
    protected String agentID = "PureProvider " + (agentIDCounter++)

    /**
     *
     * Generate Resource
     * @method GenerateResource
     *
     */
    public void GenerateResource(typeQuality, typeQueueLength) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        ArrayList types = 1..10
        SimUtilities.shuffle(types,RandomHelper.getUniform())

        // This is a loop.
        for (i in 0..<RandomHelper.nextIntFromTo(1,4)) {

            // This is a task.
            Resource res = new Resource()
            res.setQuality(RandomHelper.nextDoubleFromTo(0,30))
            res.setType(types[i])
            res.setCapacity(RandomHelper.nextIntFromTo(10, 17))
            res.setAvailable(res.getCapacity())
            // This is a task.
            res.setOwner(this)
            this.candidates << res
            println "create resource " + res.toString() + " with type " + res.getType()
            this.ResourceJudege(typeQuality,typeQueueLength,types[i],res)
            res.setSourceable(res.getCapacity())

        }

    }

    /**
     *
     * This is the step behavior.
     * @method addResource
     *
     */
    public def addResource(res) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        this.resourceList << res
        // Return the results.
        return returnValue

    }

    /**
     *
     * Judge the resource to exit
     * @method ResourceJudege
     *
     */
    public def ResourceJudege(typeQuality, typeQueueLength, type, res) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (type in typeQuality.keySet()) {


            // This is an agent decision.
            if (typeQueueLength[type] < 5) {

                // This is a task.
                double mu = this.WM(typeQuality[type])
                double sigma = this.WSTD(typeQuality[type])
                RandomHelper.createNormal(mu,sigma)

                // This is an agent decision.
                if (RandomHelper.getNormal().nextDouble() > res.getQuality()) {

                    // This is a task.
                    this.candidates.remove(res)

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
     * This is the step behavior.
     * @method Enter
     *
     */
    public def Enter(platform) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (this.candidates.isEmpty()) {

            // This is a task.
            returnValue = false

        } else  {


            // This is a loop.
            for (res in this.candidates) {

                // This is a task.
                AddAgentToContext("Ecosystem", res)
                this.addResource(res)
                platform.Indexing(res)
                platform.NewQueue(res)

            }

            // This is a task.
            this.candidates = []
            returnValue = true

        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * Calculate weighted average
     * @method WM
     *
     */
    public def WM(dataMap) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        double tempsum = 0
        int n = 0

        // This is a loop.
        for (data in dataMap) {

            // This is a task.
            tempsum += data.key*data.value
            n += data.value

        }

        // This is a task.
        returnValue = tempsum/n
        // Return the results.
        return returnValue

    }

    /**
     *
     * Calculate the standard variation
     * @method WSTD
     *
     */
    public def WSTD(dataMap) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        double tempsum = 0
        int n = 0
        double mean = this.WM(dataMap)

        // This is a loop.
        for (data in dataMap) {

            // This is a task.
            tempsum += (data.key - mean)*(data.key - mean) *data.value
            n += data.value

        }

        // This is a task.
        returnValue = Math.sqrt(tempsum/n)
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method addTaskFrequency
     *
     */
    public def addTaskFrequency(theTask) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (theTask.getType() in this.taskFrequency.keySet()) {

            // This is a task.
            this.taskFrequency[theTask.getType()] += 1

        } else  {

            // This is a task.
            this.taskFrequency[theTask.getType()] = 1
            this.ingredient[theTask.getType()] = theTask.needResourceCapacity

        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method ServiceCall
     *
     */
    public def ServiceCall() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (true) {

            // This is a task.
            this.taskFrequency = this.taskFrequency.sort{ [-it.value,-it.key.getHardness()]}
            def pattern = this.taskFrequency.iterator()[0]

            // This is an agent decision.
            if (pattern.value >= 5) {

                // This is a task.
                this.setServiceCalling(true)
                this.callContent = this.ingredient[pattern.key]
                this.callPattern = pattern.key
                this.prototype = new Service()
                this.prototype.setAppetite(pattern.key)
                // This is a task.
                this.taskFrequency.iterator()[0].value -= 5

            } else  {


            }

        } else  {


        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method addCandidates
     *
     */
    public def addCandidates(competitor) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (competitor.getType() in this.callCandidates.keySet()) {

            // This is a task.
            this.callCandidates[competitor.getType()]<<competitor

        } else  {

            // This is a task.
            this.callCandidates[competitor.getType()] = competitor

        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method Select
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.PureProvider',
        watcheeFieldNames = 'serviceCalling',
        triggerCondition = '$watchee.toString() == $watcher.toString()',
        whenToTrigger = WatcherTriggerSchedule.LATER,
        scheduleTriggerDelta = 0.3d
    )
    public def Select(ecosystem.PureProvider watchedAgent) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is a loop.
        for (data in this.callCandidates) {

            // This is a task.
            int needCap = this.callContent[data.key]
            Evaluation(data.value)

            // This is a loop.
            for (res in data.value) {


                // This is an agent decision.
                if (needCap <= res.getSourceable()) {

                    // This is a task.
                    res.setSourceable(res.getSourceable()-needCap)
                    res.setServiceNeedCapacity(needCap)
                    this.serviceStatus[res] = false
                    this.prototype.addResource(res,needCap)
                    res.setServiceProvider(this)
                    // This is a task.
                    needCap = 0
                    break

                } else  {

                    // This is a task.
                    needCap -= res.getSourceable()
                    this.prototype.addResource(res,res.getSourceable())
                    res.setServiceProvider(this)
                    this.serviceStatus[res] = false
                    // This is a task.
                    res.setServiceNeedCapacity(res.getSourceable())
                    res.setSourceable(0)

                }

            }


        }

        // This is a task.
        this.callContent = [:]
        // Return the results.
        return returnValue

    }

    /**
     *
     * Resource Evaluation
     * @method Evaluation
     *
     */
    public def Evaluation(resourceList) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        resource.sort{[-it.getSourceable(),-it.getRank()]}
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method GenerateService
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.PureProvider',
        watcheeFieldNames = 'serviceReady',
        triggerCondition = '$watchee.toString() == $watcher.toString()',
        whenToTrigger = WatcherTriggerSchedule.LATER,
        scheduleTriggerDelta = 1d
    )
    public def GenerateService(ecosystem.PureProvider watchedAgent) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (false in this.serviceStatus.values()) {

            // This is a task.
            Object sagent = CreateAgent("Ecosystem", "ecosystem.Service")
            Service s = (Service) sagent
            s = this.getPrototype()
            this.prototype = null
            s.changeQuality()
            // This is a task.
            s.setOwner(this)

        } else  {


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

