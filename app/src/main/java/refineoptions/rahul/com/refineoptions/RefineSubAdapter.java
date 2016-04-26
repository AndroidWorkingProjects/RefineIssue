package refineoptions.rahul.com.refineoptions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;

/**
 * Created by dev3 on 26/4/16.
 */
public class RefineSubAdapter extends BaseAdapter {

    private Context context;
    private ArrayList filterSubList;
    int layoutId;
    LayoutInflater inflater;

    public RefineSubAdapter(Context context, int layoutId, ArrayList filterSubList) {
        this.context = context;
        this.layoutId = layoutId;
        this.filterSubList = filterSubList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return filterSubList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutId, null);
          final CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.refine_select);
        RefineSubListDto item= (RefineSubListDto) filterSubList.get(position);
        checkBox.setText(item.getFilterName()+"("+item.getFilterCount()+")");
        return convertView;
    }

}