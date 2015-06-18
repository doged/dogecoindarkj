/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dogecoindark.dogecoindarkj.params;

import com.dogecoindark.dogecoindarkj.core.NetworkParameters;
import com.dogecoindark.dogecoindarkj.core.Sha256Hash;
import com.dogecoindark.dogecoindarkj.core.Utils;

import static com.google.common.base.Preconditions.checkState;

/**
 * Parameters for the main production network on which people trade goods and services.
 */
public class MainNetParams extends NetworkParameters {
    public MainNetParams() {
        super();
        interval = INTERVAL;
        targetTimespan = TARGET_TIMESPAN;
        maxTarget = Utils.decodeCompactBits(0x1d00ffffL);
        dumpedPrivateKeyHeader = 183;
        addressHeader = 30;
        p2shHeader = 33;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        port = 20102;
        packetMagic= 0xe6e8e9e5L;
        genesisBlock.setDifficultyTarget(0x1d00ffffL);
        genesisBlock.setTime(1345084287L);
        genesisBlock.setNonce(2179302059L);
        id = ID_MAINNET;
        spendableCoinbaseDepth = 500;
        String genesisHash = genesisBlock.getHashAsString();
        checkState(genesisHash.equals("00000fc63692467faeb20cdb3b53200dc601d75bdfa1001463304cc790d77278"), genesisHash);

        checkpoints.put(19080, new Sha256Hash("0000000003976efbf9b0576bbac1c51f4e6597342f86e7d0242003c47bf2571a"));
        checkpoints.put(30583, new Sha256Hash("0000000006b7de652b439c60795910d3f5e322ca4b394b1143f7d398d88292cd"));
        checkpoints.put(99999, new Sha256Hash("0000000002d9c701d751fd81dd87dd62f01b95fa4ea291ce924e8d76d9cdf099"));

        dnsSeeds = new String[] {
                "107.150.39.42", "104.236.47.63"
        };
    }

    private static MainNetParams instance;
    public static synchronized MainNetParams get() {
        if (instance == null) {
            instance = new MainNetParams();
        }
        return instance;
    }

    @Override
    public String getPaymentProtocolId() {
        return PAYMENT_PROTOCOL_ID_MAINNET;
    }
}
