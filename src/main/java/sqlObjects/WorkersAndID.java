package sqlObjects;

public class WorkersAndID {

	private String WorkerName;
	private String WorkerID;
	private String DataWejscia;

	public WorkersAndID(String workerName, String workerID ) {
		super();
		WorkerName = workerName;
		WorkerID = workerID;
	}


	public WorkersAndID(String workerName, String workerID,String datawejscia) {
		super();
		WorkerName = workerName;
		WorkerID = workerID;
		DataWejscia = datawejscia;
	}



	public String getDataWejscia()
	{
		return DataWejscia;
	}
	public void setDataWejscia(String datawej)
	{
		DataWejscia = datawej;
	}


	public String getWorkerName() {
		return WorkerName;
	}
	public void setWorkerName(String workerName) {
		WorkerName = workerName;
	}
	public String getWorkerID() {
		return WorkerID;
	}
	public void setWorkerID(String workerID) {
		WorkerID = workerID;
	}
	@Override
	public String toString() {
		return "WorkersAndID [WorkerName=" + WorkerName + ", WorkerID=" + WorkerID + "]";
	}

	
	
	
}
