package francisco.p.appherramientabraille.Fragmentos;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.UUID;

import francisco.p.appherramientabraille.MainActivity;
import francisco.p.appherramientabraille.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoMayusculas extends Fragment {
    private Button btnReiniciarM;
    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;
    private Button btnE;
    private Button btnF;
    private Button btnG;
    private Button btnH;
    private Button btnI;
    private Button btnJ;
    private Button btnK;
    private Button btnL;
    private Button btnM;
    private Button btnN;
    private Button btnO;
    private Button btnP;
    private Button btnQ;
    private Button btnR;
    private Button btnS;
    private Button btnT;
    private Button btnU;
    private Button btnV;
    private Button btnW;
    private Button btnX;
    private Button btnY;
    private Button btnZ;

    //Agregado
    private static final String TAG = "bluetooth1";

    // SPP UUID service
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    // MAC-address of Bluetooth module (you must edit this line)
    private static String address = null;

    public FragmentoMayusculas() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Agregado
        address= MainActivity.address;

        MainActivity.btAdapter  = BluetoothAdapter.getDefaultAdapter();
        checkBTState();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragmento_mayusculas, container, false);
        btnReiniciarM=(Button)view.findViewById(R.id.btnReiniciarM);
        btnA=(Button)view.findViewById(R.id.btnA);
        btnB=(Button)view.findViewById(R.id.btnB);
        btnC=(Button)view.findViewById(R.id.btnC);
        btnD=(Button)view.findViewById(R.id.btnD);
        btnE=(Button)view.findViewById(R.id.btnE);
        btnF=(Button)view.findViewById(R.id.btnF);
        btnG=(Button)view.findViewById(R.id.btnG);
        btnH=(Button)view.findViewById(R.id.btnH);
        btnI=(Button)view.findViewById(R.id.btnI);
        btnJ=(Button)view.findViewById(R.id.btnJ);
        btnK=(Button)view.findViewById(R.id.btnK);
        btnL=(Button)view.findViewById(R.id.btnL);
        btnM=(Button)view.findViewById(R.id.btnM);
        btnN=(Button)view.findViewById(R.id.btnN);
        btnO=(Button)view.findViewById(R.id.btnO);
        btnP=(Button)view.findViewById(R.id.btnP);
        btnQ=(Button)view.findViewById(R.id.btnQ);
        btnR=(Button)view.findViewById(R.id.btnR);
        btnS=(Button)view.findViewById(R.id.btnS);
        btnT=(Button)view.findViewById(R.id.btnT);
        btnU=(Button)view.findViewById(R.id.btnU);
        btnV=(Button)view.findViewById(R.id.btnV);
        btnW=(Button)view.findViewById(R.id.btnW);
        btnX=(Button)view.findViewById(R.id.btnX);
        btnY=(Button)view.findViewById(R.id.btnY);
        btnZ=(Button)view.findViewById(R.id.btnZ);

        btnReiniciarM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Reiniciar", Toast.LENGTH_SHORT).show();
                sendData("_");
            }
        });
        btnA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Toast.makeText(getActivity(), "A", Toast.LENGTH_SHORT).show();
                sendData("A");

            }
        });

        btnB.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "B", Toast.LENGTH_SHORT).show();
                sendData("B");
            }
        }));
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "C", Toast.LENGTH_SHORT).show();
                sendData("C");
            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "D", Toast.LENGTH_SHORT).show();
                sendData("D");
            }
        });
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "E", Toast.LENGTH_SHORT).show();
                sendData("E");
            }
        });
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "F", Toast.LENGTH_SHORT).show();
                sendData("F");
            }
        });
        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "G", Toast.LENGTH_SHORT).show();
                sendData("G");
            }
        });
        btnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "H", Toast.LENGTH_SHORT).show();
                sendData("H");
            }
        });
        btnI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "I", Toast.LENGTH_SHORT).show();
                sendData("I");
            }
        });
        btnJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "J", Toast.LENGTH_SHORT).show();
                sendData("J");
            }
        });
        btnK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "K", Toast.LENGTH_SHORT).show();
                sendData("K");
            }
        });
        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "L", Toast.LENGTH_SHORT).show();
                sendData("L");
            }
        });
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "M", Toast.LENGTH_SHORT).show();
                sendData("M");
            }
        });
        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "N", Toast.LENGTH_SHORT).show();
                sendData("N");
            }
        });
        btnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "O", Toast.LENGTH_SHORT).show();
                sendData("O");
            }
        });

        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "P", Toast.LENGTH_SHORT).show();
                sendData("P");
            }
        });
        btnQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Q", Toast.LENGTH_SHORT).show();
                sendData("Q");
            }
        });
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "R", Toast.LENGTH_SHORT).show();
                sendData("R");
            }
        });
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "S", Toast.LENGTH_SHORT).show();
                sendData("S");
            }
        });
        btnT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "T", Toast.LENGTH_SHORT).show();
                sendData("T");
            }
        });
        btnU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "U", Toast.LENGTH_SHORT).show();
                sendData("U");
            }
        });
        btnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "V", Toast.LENGTH_SHORT).show();
                sendData("V");
            }
        });
        btnW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "W", Toast.LENGTH_SHORT).show();
                sendData("W");
            }
        });
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "X", Toast.LENGTH_SHORT).show();
                sendData("X");
            }
        });
        btnY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Y", Toast.LENGTH_SHORT).show();
                sendData("Y");
            }
        });
        btnZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Z", Toast.LENGTH_SHORT).show();
                sendData("Z");
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

        }catch (Exception ex){
            errorExit("Verifique conectividad BT", "Debe estar conectado a la herramienta. Vaya a la opción conectar.");
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "...In onPause()...");

        if (MainActivity.outStream != null) {
            // try {
            //  outStream.flush();
            // } catch (IOException e) {
            // errorExit("Fatal Error", "In onPause() and failed to flush output stream: " + e.getMessage() + ".");
            // }
        }

        // try     {
        //   btSocket.close();
        //} catch (IOException e2) {
        //     errorExit("Fatal Error", "In onPause() and failed to close socket." + e2.getMessage() + ".");
        // }


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
