package francisco.p.appherramientabraille.Fragmentos;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.UUID;

import francisco.p.appherramientabraille.MainActivity;
import francisco.p.appherramientabraille.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoNumeros extends Fragment {
private Button btnReiniciarN;
private Button btn0;
private Button btn1;
private Button btn2;
private Button btn3;
private Button btn4;
private Button btn5;
private Button btn6;
private Button btn7;
private Button btn8;
private Button btn9;

    private static final String TAG = "bluetooth1";

    // SPP UUID service
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    // MAC-address of Bluetooth module (you must edit this line)
    private static String address = null;

    public FragmentoNumeros() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        address= MainActivity.address;

        MainActivity.btAdapter  = BluetoothAdapter.getDefaultAdapter();
        checkBTState();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragmento_numeros, container, false);
        btnReiniciarN=(Button)(Button)view.findViewById(R.id.btnReiniciarN);
        btn0=(Button)(Button)view.findViewById(R.id.btn0);
        btn1=(Button)(Button)view.findViewById(R.id.btn1);
        btn2=(Button)(Button)view.findViewById(R.id.btn2);
        btn3=(Button)(Button)view.findViewById(R.id.btn3);
        btn4=(Button)(Button)view.findViewById(R.id.btn4);
        btn5=(Button)(Button)view.findViewById(R.id.btn5);
        btn6=(Button)(Button)view.findViewById(R.id.btn6);
        btn7=(Button)(Button)view.findViewById(R.id.btn7);
        btn8=(Button)(Button)view.findViewById(R.id.btn8);
        btn9=(Button)(Button)view.findViewById(R.id.btn9);

        btnReiniciarN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Reiniciar", Toast.LENGTH_SHORT).show();
                sendData("_");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "0", Toast.LENGTH_SHORT).show();
                sendData("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
                sendData("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "2", Toast.LENGTH_SHORT).show();
                sendData("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "3", Toast.LENGTH_SHORT).show();
                sendData("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "4", Toast.LENGTH_SHORT).show();
                sendData("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "5", Toast.LENGTH_SHORT).show();
                sendData("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "6", Toast.LENGTH_SHORT).show();
                sendData("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "7", Toast.LENGTH_SHORT).show();
                sendData("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "8", Toast.LENGTH_SHORT).show();
                sendData("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "9", Toast.LENGTH_SHORT).show();
                sendData("9");
            }
        });
        return view;

    }
    //Métodos BT
    private BluetoothSocket createBluetoothSocket(BluetoothDevice device) throws IOException {
        if(Build.VERSION.SDK_INT >= 10){
            try {
                final Method m = device.getClass().getMethod("createInsecureRfcommSocketToServiceRecord", new Class[] { UUID.class });
                return (BluetoothSocket) m.invoke(device, MY_UUID);
            } catch (Exception e) {
                //  Log.e(TAG, "Could not create Insecure RFComm Connection",e);
            }
        }
        return  device.createRfcommSocketToServiceRecord(MY_UUID);
    }

    @Override
    public void onResume() {
        super.onResume();
        try{
            Log.d(TAG, "...onResume - try connect...");

            // Set up a pointer to the remote node using it's address.
            BluetoothDevice device = MainActivity.btAdapter.getRemoteDevice(address);

            // Two things are needed to make a connection:
            //   A MAC address, which we got above.
            //   A Service ID or UUID.  In this case we are using the
            //     UUID for SPP.

            try {
                if(MainActivity.btSocket==null){
                    MainActivity.btSocket = createBluetoothSocket(device);
                }

            } catch (IOException e1) {
                errorExit("Fatal Error", "In onResume() and socket create failed: " + e1.getMessage() + ".");
            }

            // Discovery is resource intensive.  Make sure it isn't going on
            // when you attempt to connect and pass your message.
            MainActivity.btAdapter.cancelDiscovery();

            // Establish the connection.  This will block until it connects.
            Log.d(TAG, "...Connecting...");
            try {
                if(!MainActivity.btSocket.isConnected()){
                    MainActivity.btSocket.connect();
                }

                Log.d(TAG, "...Connection ok...");
            } catch (IOException e) {
                try {
                    MainActivity.btSocket.close();
                } catch (IOException e2) {
                    errorExit("Fatal Error", "In onResume() and unable to close socket during connection failure" + e2.getMessage() + ".");
                }
            }

            // Create a data stream so we can talk to server.
            Log.d(TAG, "...Create Socket...");

            try {
                MainActivity.outStream = MainActivity.btSocket.getOutputStream();
            } catch (IOException e) {
                errorExit("Fatal Error", "In onResume() and output stream creation failed:" + e.getMessage() + ".");
            }
        }catch (Exception e1){
            errorExit("Verifique conectividad BT", "Debe estar conectado a la herramienta. Vaya a la opción conectar.");
        }


    }

    @Override
    public void onPause() {
        super.onPause();

        if (MainActivity.outStream != null) {
            // try {
            //  outStream.flush();
            // } catch (IOException e) {
            // errorExit("Fatal Error", "In onPause() and failed to flush output stream: " + e.getMessage() + ".");
            // }
        }
    }
    private void checkBTState() {
        // Check for Bluetooth support and then check to make sure it is turned on
        // Emulator doesn't support Bluetooth and will return null
        if(MainActivity.btAdapter==null) {
            errorExit("Fatal Error", "Bluetooth not support");
        } else {
            if (MainActivity.btAdapter.isEnabled()) {
                Log.d(TAG, "...Bluetooth ON...");
            } else {
                //Prompt user to turn on Bluetooth
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 1);
            }
        }
    }

    private void errorExit(String title, String message){
        Toast.makeText(getActivity(), title + " - " + message, Toast.LENGTH_LONG).show();
    }
    private void sendData(String message) {
        byte[] msgBuffer = message.getBytes();

        Log.d(TAG, "...Send data: " + message + "...");

        try {
            MainActivity.outStream.write(msgBuffer);
        } catch (IOException e) {
            String msg = "In onResume() and an exception occurred during write: " + e.getMessage();
            if (address.equals("00:00:00:00:00:00"))
                msg = msg + ".\n\nUpdate your server address from 00:00:00:00:00:00 to the correct address on line 35 in the java code";
            msg = msg +  ".\n\nCheck that the SPP UUID: " + MY_UUID.toString() + " exists on server.\n\n";

            errorExit("Fatal Error", msg);
        }
    }

}

