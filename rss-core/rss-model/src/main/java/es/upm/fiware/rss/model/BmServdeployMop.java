/**
 * Revenue Settlement and Sharing System GE
 * Copyright (C) 2011-2014,  Javier Lucio - lucio@tid.es
 * Telefonica Investigacion y Desarrollo, S.A.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package es.upm.fiware.rss.model;

// Generated 10-feb-2012 11:04:29 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * BmServdeployMop generated by hbm2java.
 */
@Entity
@Table(name = "bm_servdeploy_mop")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class BmServdeployMop implements java.io.Serializable {

    private Long nuServiceMopId;
    private BmCustomerType bmCustomerType;
    private BmMethodsOfPayment bmMethodsOfPayment;
    private BmServiceDeployment bmServiceDeployment;
    private String tcDefaultYn;

    /**
     * Constructor.
     */
    public BmServdeployMop() {
    }

    /**
     * Constructor.
     * 
     * @param nuServiceMopId
     * @param bmCustomerType
     * @param bmMethodsOfPayment
     * @param bmServiceDeployment
     * @param tcDefaultYn
     */
    public BmServdeployMop(Long nuServiceMopId, BmCustomerType bmCustomerType, BmMethodsOfPayment bmMethodsOfPayment,
        BmServiceDeployment bmServiceDeployment, String tcDefaultYn) {
        this.nuServiceMopId = nuServiceMopId;
        this.bmCustomerType = bmCustomerType;
        this.bmMethodsOfPayment = bmMethodsOfPayment;
        this.bmServiceDeployment = bmServiceDeployment;
        this.tcDefaultYn = tcDefaultYn;
    }

    @Id
    @Column(name = "NU_SERVICE_MOP_ID", unique = true, nullable = false, precision = 22, scale = 0)
    public Long getNuServiceMopId() {
        return this.nuServiceMopId;
    }

    public void setNuServiceMopId(Long nuServiceMopId) {
        this.nuServiceMopId = nuServiceMopId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "NU_CUSTOMER_TYPE_ID", nullable = false)
    public BmCustomerType getBmCustomerType() {
        return this.bmCustomerType;
    }

    public void setBmCustomerType(BmCustomerType bmCustomerType) {
        this.bmCustomerType = bmCustomerType;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "NU_MOP_ID", nullable = false)
    public BmMethodsOfPayment getBmMethodsOfPayment() {
        return this.bmMethodsOfPayment;
    }

    public void setBmMethodsOfPayment(BmMethodsOfPayment bmMethodsOfPayment) {
        this.bmMethodsOfPayment = bmMethodsOfPayment;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NU_DEPLOYMENT_ID", nullable = false)
    public BmServiceDeployment getBmServiceDeployment() {
        return this.bmServiceDeployment;
    }

    public void setBmServiceDeployment(BmServiceDeployment bmServiceDeployment) {
        this.bmServiceDeployment = bmServiceDeployment;
    }

    @Column(name = "TC_DEFAULT_YN", nullable = false, length = 1)
    public String getTcDefaultYn() {
        return this.tcDefaultYn;
    }

    public void setTcDefaultYn(String tcDefaultYn) {
        this.tcDefaultYn = tcDefaultYn;
    }

}