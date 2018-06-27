import {Direction} from './direction';

export class Route {

  constructor(
    private _id: number,
    private _directions: Array<Direction>
  ){}


  get id(): number {
    return this._id;
  }

  get directions(): Array<Direction> {
    return this._directions;
  }

  set id(value: number) {
    this._id = value;
  }

  set directions(value: Array<Direction>) {
    this._directions = value;
  }
}

