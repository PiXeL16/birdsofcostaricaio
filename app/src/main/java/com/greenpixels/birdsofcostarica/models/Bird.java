package com.greenpixels.birdsofcostarica.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;


/**
 * Bird entity
 *
 * @author PiXeL16
 * @date 5/26/15
 */
@ParcelablePlease
public class Bird implements Parcelable {

    long _id;
    String _created;
    String _modified;
    String _description;
    String _englishName;
    String _spanishName;
    String _scientificName;
    String _status;
    String _thumbnailURL;
    int    _minAltitud;
    int    _maxAltitud;
    int    _size;
    String _descriptionYear;
    String _pastScientificNames;
    String _seasonalitySpanish;
    String _diagnosticDescriptionSpanish;
    String _relationshipsSpanish;
    String _distributionCostaRicaSpanish;
    String _distributionOutsideCostaRicaSpanish;
    String _nestSpanish;
    String _habitasSpanish;
    String _feedingHabitsSpanish;
    String _conservationAreasDistributionSpanish;
    String _behaviorSpanish;
    String _mythsSpanish;
    String _conservationStatus;
    String _authorTax;
    String _territorySpanish;

    public Bird() {
    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        BirdParcelablePlease.writeToParcel(this, dest, flags);
    }

    public static final Creator<Bird> CREATOR = new Creator<Bird>() {
        public Bird createFromParcel(Parcel source) {
            Bird target = new Bird();
            BirdParcelablePlease.readFromParcel(target, source);
            return target;
        }

        public Bird[] newArray(int size) {
            return new Bird[size];
        }
    };

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getCreated() {
        return _created;
    }

    public void setCreated(String created) {
        _created = created;
    }

    public String getModified() {
        return _modified;
    }

    public void setModified(String modified) {
        _modified = modified;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getEnglishName() {
        return _englishName;
    }

    public void setEnglishName(String englishName) {
        _englishName = englishName;
    }

    public String getSpanishName() {
        return _spanishName;
    }

    public void setSpanishName(String spanishName) {
        _spanishName = spanishName;
    }

    public String getScientificName() {
        return _scientificName;
    }

    public void setScientificName(String scientificName) {
        _scientificName = scientificName;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String status) {
        _status = status;
    }

    public String getThumbnailURL() {
        return _thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        _thumbnailURL = thumbnailURL;
    }

    public int getMinAltitud() {
        return _minAltitud;
    }

    public void setMinAltitud(int minAltitud) {
        _minAltitud = minAltitud;
    }

    public int getMaxAltitud() {
        return _maxAltitud;
    }

    public void setMaxAltitud(int maxAltitud) {
        _maxAltitud = maxAltitud;
    }

    public int getSize() {
        return _size;
    }

    public void setSize(int size) {
        _size = size;
    }

    public String getDescriptionYear() {
        return _descriptionYear;
    }

    public void setDescriptionYear(String descriptionYear) {
        _descriptionYear = descriptionYear;
    }

    public String getPastScientificNames() {
        return _pastScientificNames;
    }

    public void setPastScientificNames(String pastScientificNames) {
        _pastScientificNames = pastScientificNames;
    }

    public String getSeasonalitySpanish() {
        return _seasonalitySpanish;
    }

    public void setSeasonalitySpanish(String seasonalitySpanish) {
        _seasonalitySpanish = seasonalitySpanish;
    }

    public String getDiagnosticDescriptionSpanish() {
        return _diagnosticDescriptionSpanish;
    }

    public void setDiagnosticDescriptionSpanish(String diagnosticDescriptionSpanish) {
        _diagnosticDescriptionSpanish = diagnosticDescriptionSpanish;
    }

    public String getRelationshipsSpanish() {
        return _relationshipsSpanish;
    }

    public void setRelationshipsSpanish(String relationshipsSpanish) {
        _relationshipsSpanish = relationshipsSpanish;
    }

    public String getDistributionCostaRicaSpanish() {
        return _distributionCostaRicaSpanish;
    }

    public void setDistributionCostaRicaSpanish(String distributionCostaRicaSpanish) {
        _distributionCostaRicaSpanish = distributionCostaRicaSpanish;
    }

    public String getDistributionOutsideCostaRicaSpanish() {
        return _distributionOutsideCostaRicaSpanish;
    }

    public void setDistributionOutsideCostaRicaSpanish(String distributionOutsideCostaRicaSpanish) {
        _distributionOutsideCostaRicaSpanish = distributionOutsideCostaRicaSpanish;
    }

    public String getNestSpanish() {
        return _nestSpanish;
    }

    public void setNestSpanish(String nestSpanish) {
        _nestSpanish = nestSpanish;
    }

    public String getHabitasSpanish() {
        return _habitasSpanish;
    }

    public void setHabitasSpanish(String habitasSpanish) {
        _habitasSpanish = habitasSpanish;
    }

    public String getFeedingHabitsSpanish() {
        return _feedingHabitsSpanish;
    }

    public void setFeedingHabitsSpanish(String feedingHabitsSpanish) {
        _feedingHabitsSpanish = feedingHabitsSpanish;
    }

    public String getConservationAreasDistributionSpanish() {
        return _conservationAreasDistributionSpanish;
    }

    public void setConservationAreasDistributionSpanish(String conservationAreasDistributionSpanish) {
        _conservationAreasDistributionSpanish = conservationAreasDistributionSpanish;
    }

    public String getBehaviorSpanish() {
        return _behaviorSpanish;
    }

    public void setBehaviorSpanish(String behaviorSpanish) {
        _behaviorSpanish = behaviorSpanish;
    }

    public String getMythsSpanish() {
        return _mythsSpanish;
    }

    public void setMythsSpanish(String mythsSpanish) {
        _mythsSpanish = mythsSpanish;
    }

    public String getConservationStatus() {
        return _conservationStatus;
    }

    public void setConservationStatus(String conservationStatus) {
        _conservationStatus = conservationStatus;
    }

    public String getAuthorTax() {
        return _authorTax;
    }

    public void setAuthorTax(String authorTax) {
        _authorTax = authorTax;
    }

    public String getTerritorySpanish() {
        return _territorySpanish;
    }

    public void setTerritorySpanish(String territorySpanish) {
        _territorySpanish = territorySpanish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bird bird = (Bird) o;

        if (_id != bird._id) return false;
        return _scientificName.equals(bird._scientificName);

    }

    @Override
    public int hashCode() {
        int result = (int) (_id ^ (_id >>> 32));
        result = 31 * result + _scientificName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "_id=" + _id +
                ", _created='" + _created + '\'' +
                ", _modified='" + _modified + '\'' +
                ", _description='" + _description + '\'' +
                ", _englishName='" + _englishName + '\'' +
                ", _spanishName='" + _spanishName + '\'' +
                ", _scientificName='" + _scientificName + '\'' +
                ", _status='" + _status + '\'' +
                ", _thumbnailURL='" + _thumbnailURL + '\'' +
                ", _minAltitud=" + _minAltitud +
                ", _maxAltitud=" + _maxAltitud +
                ", _size=" + _size +
                ", _descriptionYear='" + _descriptionYear + '\'' +
                ", _pastScientificNames='" + _pastScientificNames + '\'' +
                ", _seasonalitySpanish='" + _seasonalitySpanish + '\'' +
                ", _diagnosticDescriptionSpanish='" + _diagnosticDescriptionSpanish + '\'' +
                ", _relationshipsSpanish='" + _relationshipsSpanish + '\'' +
                ", _distributionCostaRicaSpanish='" + _distributionCostaRicaSpanish + '\'' +
                ", _distributionOutsideCostaRicaSpanish='" + _distributionOutsideCostaRicaSpanish + '\'' +
                ", _nestSpanish='" + _nestSpanish + '\'' +
                ", _habitasSpanish='" + _habitasSpanish + '\'' +
                ", _feedingHabitsSpanish='" + _feedingHabitsSpanish + '\'' +
                ", _conservationAreasDistributionSpanish='" + _conservationAreasDistributionSpanish + '\'' +
                ", _behaviorSpanish='" + _behaviorSpanish + '\'' +
                ", _mythsSpanish='" + _mythsSpanish + '\'' +
                ", _conservationStatus='" + _conservationStatus + '\'' +
                ", _authorTax='" + _authorTax + '\'' +
                ", _territorySpanish='" + _territorySpanish + '\'' +
                '}';
    }
}
