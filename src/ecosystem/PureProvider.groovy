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
     * This is an agent property.
     * @field serviceList
     *
     */
    @Parameter (displayName = "Service List", usageName = "serviceList")
    public ArrayList getServiceList() {
        return serviceList
    }
    public void setServiceList(ArrayList newValue) {
        serviceList = newValue
    }
    public ArrayList serviceList = new ArrayList()

    /**
     *
     * This is an agent property.
     * @field resourceList
     *
     */
    @Parameter (displayName = "Resource List", usageName = "resourceList")
    public ArrayList getResourceList() {
        return resourceList
    }
    public void setResourceList(ArrayList newValue) {
        resourceList = newValue
    }
    public ArrayList resourceList = new ArrayList()

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
     * This is the step behavior.
     * @method Init
     *
     */
    public void Init() {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // Set the resourceCount
        int resourceCount = 5

        // This is a loop.
        for (i in 1..resourceCount) {

            // This is a task.
            Object ragent = CreateAgent("Ecosystem", "ecosystem.Resource")
            Resource r = (Resource) ragent
            r.addOwner(this.toString())
            this.resourceList.add(r)
            Object sagent = CreateAgent("Ecosystem", "ecosystem.Service")
            Service s = (Service) sagent
            r.addMaster(s.toString())
            s.AddResource(r)
            s.addOwner(this.toString())
            this.serviceList.add(s)

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

