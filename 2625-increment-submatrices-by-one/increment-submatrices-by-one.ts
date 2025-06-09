function rangeAddQueries(n: number, queries: number[][]): number[][] {
    let k : number = queries.length;
    let mat : number[][] = [];

    for (let i = 0; i < n; i++) {
        mat.push(new Array(n).fill(0));
    }

    for(let z=0; z< k; z++) {
        let q : number[] = queries[z];
        let r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
        mat[r1][c1] += 1;

        if(c2+1 < n ) mat[r1][c2 + 1] -= 1;
        if(r2+1 < n && c2+1 < n) mat[r2 + 1][c2+1] += 1;
        if(r2+1 < n) mat[r2+1][c1] -= 1;

    }

    

    for(let i= 1; i< n ; i++) {
        for(let j= 0; j< n; j++) {
            mat[i][j] += mat[i-1][j];
        }
    }
    for(let i= 0; i< n ; i++) {
        for(let j= 1; j< n; j++) {
            mat[i][j] += mat[i][j-1];
        }
    }
    return mat;

};