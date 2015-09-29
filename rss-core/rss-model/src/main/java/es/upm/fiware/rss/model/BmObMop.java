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

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * BmObMop generated by hbm2java.
 */
@Entity
@Table(name = "bm_ob_mop")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class BmObMop implements java.io.Serializable {

    private BmObMopId id;
    private BmObCountry bmObCountry;
    private BmMethodsOfPayment bmMethodsOfPayment;
    private BmPaymentbroker bmPaymentbroker;
    private Date dtStartDate;

    /**
     * Constructor.
     */
    public BmObMop() {
    }

    /**
     * Constructor.
     * 
     * @param id
     * @param bmObCountry
     * @param bmMethodsOfPayment
     * @param bmPaymentbroker
     * @param dtStartDate
     */
    public BmObMop(BmObMopId id, BmObCountry bmObCountry, BmMethodsOfPayment bmMethodsOfPayment,
        BmPaymentbroker bmPaymentbroker, Date dtStartDate) {
        this.id = id;
        this.bmObCountry = bmObCountry;
        this.bmMethodsOfPayment = bmMethodsOfPayment;
        this.bmPaymentbroker = bmPaymentbroker;
        this.dtStartDate = dtStartDate;
    }

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "nuObId", column = @Column(name = "NU_OB_ID", nullable = false, precision = 10,
            scale = 0)),
        @AttributeOverride(name = "nuCountryId", column = @Column(name = "NU_COUNTRY_ID", nullable = false,
            precision = 10, scale = 0)),
        @AttributeOverride(name = "nuMopId", column = @Column(name = "NU_MOP_ID", nullable = false, precision = 10,
            scale = 0))
    })
    public BmObMopId getId() {
        return this.id;
    }

    public void setId(BmObMopId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "NU_OB_ID", referencedColumnName = "NU_OB_ID", nullable = false, insertable = false,
            updatable = false),
        @JoinColumn(name = "NU_COUNTRY_ID", referencedColumnName = "NU_COUNTRY_ID", nullable = false,
            insertable = false, updatable = false)
    })
    public BmObCountry getBmObCountry() {
        return this.bmObCountry;
    }

    public void setBmObCountry(BmObCountry bmObCountry) {
        this.bmObCountry = bmObCountry;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "NU_MOP_ID", nullable = false, insertable = false, updatable = false)
    public BmMethodsOfPayment getBmMethodsOfPayment() {
        return this.bmMethodsOfPayment;
    }

    public void setBmMethodsOfPayment(BmMethodsOfPayment bmMethodsOfPayment) {
        this.bmMethodsOfPayment = bmMethodsOfPayment;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BM_PB_ID", nullable = true)
    public BmPaymentbroker getBmPaymentbroker() {
        return this.bmPaymentbroker;
    }

    public void setBmPaymentbroker(BmPaymentbroker bmPaymentbroker) {
        this.bmPaymentbroker = bmPaymentbroker;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_START_DATE", nullable = false, length = 7)
    public Date getDtStartDate() {
        return this.dtStartDate;
    }

    public void setDtStartDate(Date dtStartDate) {
        this.dtStartDate = dtStartDate;
    }

}