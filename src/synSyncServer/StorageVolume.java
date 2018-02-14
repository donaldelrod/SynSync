package synSyncServer;

public class StorageVolume {
	public static final int BYTE=0;
	public static final int KILO=1;
	public static final int MEGA=2;
	public static final int GIGA=3;
	public static final int TERA=4;
	
	private char[] driveLetter;
	
	private long[] totalCapacity;
	private long[] usedCapacity;
	private long[] emptyCapacity;
	
	public StorageVolume(char[] driveLetters, long[] totalCapacities, long[] usedCapacities, long[] emptyCapacities) {
		driveLetter=driveLetters;
		totalCapacity=totalCapacities;
		usedCapacity=usedCapacities;
		emptyCapacity=emptyCapacities;
	}
	
	public double getTotalSpace(int index, int format) {
		switch (format) {
		case BYTE:
			return totalCapacity[index];
		case KILO:
			return totalCapacity[index]/1024;
		case MEGA:
			return totalCapacity[index]/1024/1024;
		case GIGA:
			return totalCapacity[index]/1024/1024/1024;
		case TERA:
			return totalCapacity[index]/1024/1024/1024/1024;
			default:
				return totalCapacity[index];
		}
	}
	
	public double getEmptySpace(int index, int format) {
		switch (format) {
		case BYTE:
			return emptyCapacity[index];
		case KILO:
			return emptyCapacity[index]/1024;
		case MEGA:
			return emptyCapacity[index]/1024/1024;
		case GIGA:
			return emptyCapacity[index]/1024/1024/1024;
		case TERA:
			return emptyCapacity[index]/1024/1024/1024/1024;
			default:
				return emptyCapacity[index];
		}
	}
	
	public double getUsedSpace(int index, int format) {
		switch (format) {
		case BYTE:
			return usedCapacity[index];
		case KILO:
			return usedCapacity[index]/1024;
		case MEGA:
			return usedCapacity[index]/1024/1024;
		case GIGA:
			return usedCapacity[index]/1024/1024/1024;
		case TERA:
			return usedCapacity[index]/1024/1024/1024/1024;
			default:
				return usedCapacity[index];
		}
	}
	
	public char getDriveLetter(int index) {return driveLetter[index];}
	
}