package store;

import java.util.ArrayList;
import java.util.List;

public class DataChangeManager {

	public static DataChangeManager sDataChangeManager = new DataChangeManager();
	
	public List<DataChangeListener>DataChangeListenerList = new ArrayList();
	
	
	public static DataChangeManager getDataManager(){
		return sDataChangeManager;
	}
	public void registerListener(DataChangeListener l){
		System.out.println("registerListener");
		DataChangeListenerList.add(l);
	}
	public void unRegisterListener(DataChangeListener l){
		DataChangeListenerList.remove(l);
	}
	
	public void DataIseart(){
		for(DataChangeListener d:DataChangeListenerList){
			d.DataIseart();
		}
	}
	public void DataUpdate(){
		for(DataChangeListener d:DataChangeListenerList){
			d.DataUpdate();
		}
	}
	public void DataDelete(){
		for(DataChangeListener d:DataChangeListenerList){
			d.DataDelete();
		}
	}
	
}
