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
public class Provider extends ecosystem.User  {

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
    public double rank = 0

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
     * @field serdata
     *
     */
    @Parameter (displayName = "Service Call Data", usageName = "serdata")
    public def getSerdata() {
        return serdata
    }
    public void setSerdata(def newValue) {
        serdata = newValue
    }
    public def serdata = [[2:1,3:1,4:1],
						[2:4],
						[2:6],
						[1:1],
						[3:5,4:7],
						[2:7,3:7,4:5],
						[1:7,2:6,4:5],
						[1:7,4:6],
						[1:5,2:6,3:7,4:6]]

    /**
     *
     * This is an agent property.
     * @field serviceConf
     *
     */
    @Parameter (displayName = "Service config count", usageName = "serviceConf")
    public def getServiceConf() {
        return serviceConf
    }
    public void setServiceConf(def newValue) {
        serviceConf = newValue
    }
    public def serviceConf = [:]

    /**
     *
     * This is an agent property.
     * @field newService
     *
     */
    @Parameter (displayName = "New Service", usageName = "newService")
    public def getNewService() {
        return newService
    }
    public void setNewService(def newValue) {
        newService = newValue
    }
    public def newService = null

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
    protected String agentID = "Provider " + (agentIDCounter++)

    /**
     *
     * This is the step behavior.
     * @method addTaskFrequency
     *
     */
    public void addTaskFrequency(resConf) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (resConf in this.taskFrequency.keySet()) {

            // This is a task.
            this.taskFrequency[resConf] += 1

        } else  {

            // This is a task.
            this.taskFrequency[resConf] = 1
            this.serviceConf[resConf] = 0

        }
    }

    /**
     *
     * This is the step behavior.
     * @method GenerateService
     *
     */
    public void GenerateService(serviceData) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (true) {

            // This is a task.
            Service s = new Service()
            s.setValues(serviceData)
            s.setOwner(this)
            this.newService = s

        } else  {


        }
    }

    /**
     *
     * Generate Resource
     * @method GenerateResource
     *
     */
    public void GenerateResource() {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        ArrayList types = 1..12
        SimUtilities.shuffle(types,RandomHelper.getUniform())
        types = types.take(RandomHelper.nextIntFromTo(0,4))

        // This is a loop.
        for (type in types) {

            // This is a task.
            Resource res = new Resource()
            res.setMu(RandomHelper.nextDoubleFromTo(0,30))
            res.setType(type)
            res.setCapacity(RandomHelper.nextIntFromTo(10, 20))
            res.setAvailable(res.getCapacity())
            // This is a task.
            res.setOwner(this)
            this.resourceList << res
            res.setSigma(RandomHelper.nextDoubleFromTo(0,5))
            //this.ResourceJudege(typeQuality,typeQueueLength,types[i],res)
            res.setSourceable(res.getCapacity())

        }

    }

    /**
     *
     * This is the step behavior.
     * @method RemoveServiceCall
     *
     */
    public void RemoveServiceCall(sc) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        RemoveAgentFromContext("Ecosystem", sc)
    }

    /**
     *
     * This is the step behavior.
     * @method GenerateServiceCall
     *
     */
    @ScheduledMethod(
        start = 1d,
        interval = 1d,
        shuffle = true
    )
    public void GenerateServiceCall() {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (RunEnvironment.getInstance().getParameters().getValue("Service")) {


            // This is an agent decision.
            if (true) {

                // This is a task.
                this.taskFrequency = this.taskFrequency.sort{- it.value }
                def pattern = this.taskFrequency.iterator()[0]

                // This is an agent decision.
                if (this.taskFrequency.size() > 0 && pattern.value > 5) {

                    // This is a task.
                    ServiceCall sagent = CreateAgent("Ecosystem", "ecosystem.ServiceCall")
                    sagent.setParameters(pattern.key)
                    sagent.setOwner(this)
                    // This is a task.
                    this.taskFrequency[pattern.key] -= 5

                } else  {


                }

            } else  {


            }

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

