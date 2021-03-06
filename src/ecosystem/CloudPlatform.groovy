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
 * Platform of cloud mfg
 *
 */
public class CloudPlatform  {

    /**
     *
     * User list to record the user exist in the platform
     * @field userList
     *
     */
    @Parameter (displayName = "User List", usageName = "userList")
    public ArrayList getUserList() {
        return userList
    }
    public void setUserList(ArrayList newValue) {
        userList = newValue
    }
    public ArrayList userList = new ArrayList()

    /**
     *
     * This is an agent property.
     * @field mean1
     *
     */
    @Parameter (displayName = "Mean1", usageName = "mean1")
    public double getMean1() {
        return mean1
    }
    public void setMean1(double newValue) {
        mean1 = newValue
    }
    public double mean1 = 0.16

    /**
     *
     * Count the fininshed jobs
     * @field finishCount
     *
     */
    @Parameter (displayName = "Finish Count", usageName = "finishCount")
    public int getFinishCount() {
        return finishCount
    }
    public void setFinishCount(int newValue) {
        finishCount = newValue
    }
    public int finishCount = 0

    /**
     *
     * Count the fininshed jobs
     * @field serviceGeneratedCount
     *
     */
    @Parameter (displayName = "Service Generate count", usageName = "serviceGeneratedCount")
    public int getServiceGeneratedCount() {
        return serviceGeneratedCount
    }
    public void setServiceGeneratedCount(int newValue) {
        serviceGeneratedCount = newValue
    }
    public int serviceGeneratedCount = 0

    /**
     *
     * [type: amount]
     * @field serviceStyleAmount
     *
     */
    @Parameter (displayName = "Service Map", usageName = "serviceStyleAmount")
    public Map getServiceStyleAmount() {
        return serviceStyleAmount
    }
    public void setServiceStyleAmount(Map newValue) {
        serviceStyleAmount = newValue
    }
    public Map serviceStyleAmount = [:]

    /**
     *
     * This is an agent property.
     * @field resourceList
     *
     */
    @Parameter (displayName = "Resource List registered", usageName = "resourceList")
    public List getResourceList() {
        return resourceList
    }
    public void setResourceList(List newValue) {
        resourceList = newValue
    }
    public List resourceList = []

    /**
     *
     * This is an agent property.
     * @field serviceList
     *
     */
    @Parameter (displayName = "Service List", usageName = "serviceList")
    public List getServiceList() {
        return serviceList
    }
    public void setServiceList(List newValue) {
        serviceList = newValue
    }
    public List serviceList = []

    /**
     *
     * [type: amount]
     * @field resourceTypeAmount
     *
     */
    @Parameter (displayName = "Resource Map", usageName = "resourceTypeAmount")
    public Map getResourceTypeAmount() {
        return resourceTypeAmount
    }
    public void setResourceTypeAmount(Map newValue) {
        resourceTypeAmount = newValue
    }
    public Map resourceTypeAmount = [:]

    /**
     *
     * This is an agent property.
     * @field providerList
     *
     */
    @Parameter (displayName = "Providers", usageName = "providerList")
    public List getProviderList() {
        return providerList
    }
    public void setProviderList(List newValue) {
        providerList = newValue
    }
    public List providerList = []

    /**
     *
     * This is an agent property.
     * @field needResourceCapacity
     *
     */
    @Parameter (displayName = "Need Cap", usageName = "needResourceCapacity")
    public Map getNeedResourceCapacity() {
        return needResourceCapacity
    }
    public void setNeedResourceCapacity(Map newValue) {
        needResourceCapacity = newValue
    }
    public Map needResourceCapacity = [:]

    /**
     *
     * This is an agent property.
     * @field resourceRecycleList
     *
     */
    @Parameter (displayName = "Resource Recycle List", usageName = "resourceRecycleList")
    public List getResourceRecycleList() {
        return resourceRecycleList
    }
    public void setResourceRecycleList(List newValue) {
        resourceRecycleList = newValue
    }
    public List resourceRecycleList = []

    /**
     *
     * This is an agent property.
     * @field serviceRecycleList
     *
     */
    @Parameter (displayName = "Service Recycle List", usageName = "serviceRecycleList")
    public List getServiceRecycleList() {
        return serviceRecycleList
    }
    public void setServiceRecycleList(List newValue) {
        serviceRecycleList = newValue
    }
    public List serviceRecycleList = []

    /**
     *
     * This is an agent property.
     * @field servicePattern
     *
     */
    @Parameter (displayName = "Serivce Pattern", usageName = "servicePattern")
    public Map getServicePattern() {
        return servicePattern
    }
    public void setServicePattern(Map newValue) {
        servicePattern = newValue
    }
    public Map servicePattern = [:]

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
    protected String agentID = "CloudPlatform " + (agentIDCounter++)

    /**
     *
     * Add user including pure and complex users
     * @method addUser
     *
     */
    public void addUser(userID) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        this.userList << userID
    }

    /**
     *
     * Eliminate user include pure and complex users
     * @method EliminateUser
     *
     */
    public void EliminateUser(Object o) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        this.userList.remove(o)
    }

    /**
     *
     * Create provider procedure
     * @method CreateProvider
     *
     */
    @ScheduledMethod(
        start = 1d,
        interval = 1d,
        shuffle = true
    )
    public void CreateProvider() {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        Parameters params = RunEnvironment.getInstance().getParameters()
        double mean = params.getValue("Provider")
        RandomHelper.createPoisson(mean)

        // This is a loop.
        for (int i in RandomHelper.getPoisson().nextInt()) {

            // Create Provider at a random distribution
            Provider pagent = new Provider()
            // pagent.GenerateResource(this.typeQuality,this.typeQueueLength)
            pagent.GenerateResource()
            this.addProvider(pagent)

        }

    }

    /**
     *
     * catch the finish task and add the count
     * @method Accumulator
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.Job',
        watcheeFieldNames = 'finish',
        whenToTrigger = WatcherTriggerSchedule.IMMEDIATE,
        scheduleTriggerDelta = 1d
    )
    public def Accumulator(ecosystem.Job watchedAgent) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (watchedAgent.getClass() == ecosystem.Task) {

            // This is a task.
            this.finishCount ++

        } else  {

            // This is a task.
            this.serviceGeneratedCount++

        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method ServiceQuality
     *
     */
    public def ServiceQuality(style) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        List styleList = this.serviceList.findAll{ it-> it.resourceComposition == style }
        // This is a task.
        Service s = styleList[0]
        double minq = s.getQuality()

        // This is a loop.
        for (ser in styleList) {

            // This is a task.
            double theq = ser.getQuality()

            // This is an agent decision.
            if (theq < minq) {

                // This is a task.
                minq = theq
                s = ser

            } else  {


            }

        }

        // This is a task.
        returnValue = s
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method addService
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.Provider',
        watcheeFieldNames = 'newService',
        whenToTrigger = WatcherTriggerSchedule.IMMEDIATE
    )
    public void addService(ecosystem.Provider watchedAgent) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        Service s = watchedAgent.newService
        Map style = s.resourceComposition

        // This is an agent decision.
        if (s.resourceContribution.keySet().findIndexOf{ it -> it.exit==true } > -1 || this.servicePattern[style] < this.serviceStyleAmount[style]) {

            // This is a task.
            s.ReturnResources()

        } else  {


            // This is an agent decision.
            if (this.serviceStyleAmount[style] ==null) {

                // This is a task.
                AddAgentToContext("Ecosystem", s)
                this.serviceList << s
                watchedAgent.serviceList << s

                // This is an agent decision.
                if (style in this.serviceStyleAmount.keySet()) {

                    // This is a task.
                    this.serviceStyleAmount[style] += 1

                } else  {

                    // This is a task.
                    this.serviceStyleAmount[style] = 1

                }

            } else  {

                // This is a task.
                def minSer = this.ServiceQuality(style)

                // This is an agent decision.
                if (minSer.getQuality() > s.getQuality()) {

                    // This is a task.
                    s.ReturnResources()

                } else  {

                    // This is a task.
                    AddAgentToContext("Ecosystem", s)
                    this.serviceList << s
                    watchedAgent.serviceList << s
                    minSer.exit = true
                    this.serviceRecycleList << minSer

                    // This is an agent decision.
                    if (style in this.serviceStyleAmount.keySet()) {

                        // This is a task.
                        this.serviceStyleAmount[style] += 1

                    } else  {

                        // This is a task.
                        this.serviceStyleAmount[style] = 1

                    }

                }

            }

        }
    }

    /**
     *
     * This is the step behavior.
     * @method ResourceQuality
     *
     */
    public double ResourceQuality(type) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        List typeResList = this.resourceList.findAll{ it-> it.getType() == type }
        // This is a task.
        double minq = typeResList[0].getQuality()

        // This is a loop.
        for (res in typeResList) {

            // This is a task.
            double theq = res.getQuality()

            // This is an agent decision.
            if (theq < minq) {

                // This is a task.
                minq = theq

            } else  {


            }

        }

        // This is a task.
        returnValue = minq
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method addProvider
     *
     */
    public void addProvider(p) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        List resList = p.resourceList.collect()

        // This is a loop.
        for (res in resList) {

            // This is a task.
            def type = res.getType()

            // This is an agent decision.
            if (this.resourceTypeAmount[type] > 0 && this.needResourceCapacity[type] < this.resourceTypeAmount[type]) {


                // This is an agent decision.
                if (this.needResourceCapacity[type] < this.resourceTypeAmount[type]/RunEnvironment.getInstance().getParameters().getValue("ScarcityFactor")) {

                    // This is a task.
                    p.resourceList.remove(res)

                } else  {


                    // This is an agent decision.
                    if (this.ResourceQuality(type) > res.getQuality()) {

                        // This is a task.
                        p.resourceList.remove(res)

                    } else  {

                        // This is a task.
                        this.UpdateResource(type,res.getCapacity())

                    }

                }

            } else  {


            }

        }


        // This is a loop.
        for (res in p.resourceList) {

            // This is a task.
            AddAgentToContext("Ecosystem", res)
            this.resourceList << res

            // This is an agent decision.
            if (res.getType() in this.resourceTypeAmount.keySet()) {

                // This is a task.
                this.resourceTypeAmount[res.getType()] += res.getCapacity()

            } else  {

                // This is a task.
                this.resourceTypeAmount[res.getType()] = res.getCapacity()

            }

        }


        // This is an agent decision.
        if (p.resourceList.size() > 0) {

            // This is a task.
            AddAgentToContext("Ecosystem", p)
            this.providerList << p

        } else  {


        }
    }

    /**
     *
     * This is the step behavior.
     * @method Recycle
     *
     */
    @ScheduledMethod(
        start = 1d,
        interval = 1d,
        shuffle = true
    )
    public def Recycle() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (RunEnvironment.getInstance().getParameters().getValue("Metabolism")) {


            // This is a loop.
            for (ser in this.serviceRecycleList.collect()) {


                // This is an agent decision.
                if (ser.getFullLength() == 0) {

                    // This is a task.
                    this.serviceList.remove(ser)
                    this.serviceStyleAmount[ser.resourceComposition] -= 1
                    ser.owner.serviceList.remove(ser)
                    ser.ReturnResources()
                    RemoveAgentFromModel(ser)
                    // This is a task.
                    this.serviceRecycleList.remove(ser)

                } else  {


                }

            }


            // This is a loop.
            for (res in this.resourceRecycleList.collect()) {


                // This is an agent decision.
                if (res.getFullLength() == 0 && res.master.size() == 0) {

                    // This is a task.
                    this.resourceList.remove(res)
                    this.resourceTypeAmount[res.getType()] -= res.capacity
                    res.owner.resourceList.remove(res)
                    RemoveAgentFromModel(res)
                    // This is a task.
                    this.resourceRecycleList.remove(res)

                } else  {


                }

            }


            // This is a loop.
            for (p in this.providerList.collect()) {


                // This is an agent decision.
                if (p.serviceList.size() + p.resourceList.size() == 0) {

                    // This is a task.
                    this.providerList.remove(p)
                    RemoveAgentFromModel(p)

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
     * This is the step behavior.
     * @method addNeedCap
     *
     */
    public void addNeedCap(ecosystem.Task watchedAgent) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is a loop.
        for (data in watchedAgent.needResourceCapacity) {


            // This is an agent decision.
            if (data.key in this.needResourceCapacity.keySet()) {

                // This is a task.
                this.needResourceCapacity[data.key] += data.value
                //println this.needResourceCapacity

            } else  {

                // This is a task.
                this.needResourceCapacity[data.key] = data.value
                //println this.needResourceCapacity

            }

        }


        // This is an agent decision.
        if (watchedAgent.needResourceCapacity in this.servicePattern.keySet()) {

            // This is a task.
            this.servicePattern[watchedAgent.needResourceCapacity] += 1

        } else  {

            // This is a task.
            this.servicePattern[watchedAgent.needResourceCapacity] = 1

        }
    }

    /**
     *
     * This is the step behavior.
     * @method releaseNeedCap
     *
     */
    public void releaseNeedCap(ecosystem.Task watchedAgent) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (watchedAgent.bufferMark.getClass() == ecosystem.Resource) {

            // This is a task.
            def type = watchedAgent.bufferMark.getType()
            this.needResourceCapacity[type] -= watchedAgent.needResourceCapacity[type]
            //println this.needResourceCapacity

        } else  {


            // This is a loop.
            for (resdata in watchedAgent.needResourceCapacity) {

                // This is a task.
                this.needResourceCapacity[resdata.key] -= resdata.value
                //println this.needResourceCapacity

            }

            // This is a task.
            this.servicePattern[watchedAgent.needResourceCapacity] -= 1

        }
    }

    /**
     *
     * This is the step behavior.
     * @method UpdateResource
     *
     */
    public void UpdateResource(type, amount) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (RunEnvironment.getInstance().getParameters().getValue("Metabolism")) {

            // This is a task.
            List typeList = this.resourceList.findAll{ it-> it.getType() == type }

            // This is an agent decision.
            if (typeList.size() > 0) {

                // This is a task.
                typeList = typeList.sort{ it.mu }

                // This is a loop.
                for (res in typeList) {


                    // This is an agent decision.
                    if (amount > 0) {

                        // This is a task.
                        res.exit = true
                        amount -= res.getCapacity()
                        this.resourceRecycleList << res

                    } else  {

                        // This is a task.
                        break

                    }

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

