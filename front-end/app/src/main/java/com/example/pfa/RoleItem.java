package ma.gi.pfa;

public class RoleItem {
    private String mCountryName;
    private int mFlagImage;

    public RoleItem(String countryName, int flagImage) {
        mCountryName = countryName;
        mFlagImage = flagImage;
    }

    public String getCountryName() {
        return mCountryName;
    }

    public int getFlagImage() {
        return mFlagImage;
    }
}
