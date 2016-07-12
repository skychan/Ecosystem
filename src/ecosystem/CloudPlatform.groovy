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
     * This is an agent test
     * @field needCount
     *
     */
    @Parameter (displayName = "Need Count", usageName = "needCount")
    public int getNeedCount() {
        return needCount
    }
    public void setNeedCount(int newValue) {
        needCount = newValue
    }
    public int needCount = 0

    /**
     *
     * Searche provider result list
     * @field searched
     *
     */
    @Parameter (displayName = "Searched provider", usageName = "searched")
    public ArrayList getSearched() {
        return searched
    }
    public void setSearched(ArrayList newValue) {
        searched = newValue
    }
    public ArrayList searched = new ArrayList()

    /**
     *
     * The Order hub that contains the stage orders.
     * @field orderHub
     *
     */
    @Parameter (displayName = "Order Hub", usageName = "orderHub")
    public OrderHub getOrderHub() {
        return orderHub
    }
    public void setOrderHub(OrderHub newValue) {
        orderHub = newValue
    }
    public OrderHub orderHub = (OrderHub) CreateAgent("Ecosystem","ecosystem.OrderHub")

    /**
     *
     * Record the candidates
     * @field candidates
     *
     */
    @Parameter (displayName = "Candidates", usageName = "candidates")
    public ArrayList getCandidates() {
        return candidates
    }
    public void setCandidates(ArrayList newValue) {
        candidates = newValue
    }
    public ArrayList candidates = new ArrayList()

    /**
     *
     * indicate if any of provider candidates
     * @field indicate
     *
     */
    @Parameter (displayName = "candidate indicate", usageName = "indicate")
    public boolean getIndicate() {
        return indicate
    }
    public void setIndicate(boolean newValue) {
        indicate = newValue
    }
    public boolean indicate = false

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
     * @method AddUser
     *
     */
    public void AddUser(Object o) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        this.userList.add(o)
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
        double mean = params.getValue("Mean")
        RandomHelper.createPoisson(mean)
        int providerCount = RandomHelper.getPoisson().nextInt()

        // This is a loop.
        for (int i in 0..<providerCount) {

            // Create Provider at a random distribution
            Object agent = CreateAgent("Ecosystem", "ecosystem.PureProvider")
            PureProvider pagent = (PureProvider) agent
            pagent.Init()
            this.AddUser(pagent)

        }

    }

    /**
     *
     * Watch needs then to analysis them to search resource providers.
     * @method Search
     *
     */
    public void Search(ecosystem.PureDemander dagent) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // record and add need mark and search the provider
        this.needCount += dagent.getUnit()
        this.searched.clear()

        // This is a loop.
        for (Task t in dagent.getNewOrder()) {

            // Search corresponding resource
            this.searched.addAll(t.getAlternations())

        }

        // This is a task.
    }

    /**
     *
     * Watch demanders, if any of them have need, then add the order to the order hub
     * @method InHub
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.PureDemander',
        watcheeFieldNames = 'need',
        whenToTrigger = WatcherTriggerSchedule.IMMEDIATE,
        scheduleTriggerDelta = 1d
    )
    public void InHub(ecosystem.PureDemander watchedAgent) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // add order to the order hub
        this.orderHub.Add(watchedAgent.getNewOrder())
    }

    /**
     *
     * Watch providers, if any of them have finished a order, then we should pull it off from the hub
     * @method OutHub
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.Order',
        watcheeFieldNames = 'status',
        triggerCondition = '$watchee.getStatus().values().contains(false) == false',
        whenToTrigger = WatcherTriggerSchedule.IMMEDIATE,
        scheduleTriggerDelta = 1d
    )
    public void OutHub(ecosystem.Order watchedAgent) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // remove order from the order hub
        this.orderHub.Remove(watchedAgent)
    }

    /**
     *
     * Add the competitor
     * @method AddCompetitor
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.PureProvider',
        watcheeFieldNames = 'compete',
        whenToTrigger = WatcherTriggerSchedule.IMMEDIATE,
        scheduleTriggerDelta = 1d
    )
    public def AddCompetitor(ecosystem.PureProvider watchedAgent) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // Add to the temp candidates list
        this.candidates.add(watchedAgent)
        this.setIndicate(true)
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

